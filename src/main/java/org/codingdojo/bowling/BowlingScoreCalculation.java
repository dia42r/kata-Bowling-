package org.codingdojo.bowling;

import lombok.extern.slf4j.Slf4j;
import org.codingdojo.bowling.Interface.DataReader;
import org.codingdojo.bowling.business.*;

import java.util.*;

import static org.codingdojo.bowling.helper.FrameHelper.*;

@Slf4j
public class BowlingScoreCalculation {

    private List<Frame> frames;
    private String input;
    private Score score;


    public BowlingScoreCalculation(Score score, String input) {
        this.score = score;
        this.input = input;
        this.frames = new ArrayList<Frame>();
    }


    public Integer getScore() {
        return this.score.score(this.createFrames());
    }

    private List<Frame> createFrames() {
        String firstThrow = "";
        String secondThrow = "";
        Frame frame = null;
        this.input = this.input.replaceAll("\\s","");

        for (int i = 0; i < this.input.length(); i++) {

            firstThrow = String.valueOf(this.input.charAt(i));

            if (this.frames.size() == 9) {
                frame = getLastFrame(firstThrow, secondThrow, frame, i);
                this.frames.add(frame);
                break;
            }

            if (isSpike(firstThrow)) {
                frame = SpikeFrame.create();
                this.frames.add(frame);
                continue;
            }

            secondThrow = (i < this.input.length() - 1) ? String.valueOf(this.input.charAt(i + 1)) : "0";

            if (isSpare(firstThrow, secondThrow)) {
                frame = SpareFrame.create(parse(firstThrow), 10 - parse(firstThrow));
                i++;
            }  else if (isOpen(firstThrow, secondThrow)) {
                frame = OpenFrame.create(parse(firstThrow), parse(secondThrow));
                i++;
            }

            this.frames.add(frame);
        }

        this.frames.forEach(el -> {
            log.info("[ {} , {}, {}]", el.getFirstThrow(), el.getSecondThrow(), el.getBonusBall().toString());
        });

       return this.frames;
    }

    private Frame getLastFrame(String firstThrow, String secondThrow, Frame frame, int i) {
        if (isSpike(firstThrow)) {
            frame = SpikeFrame.create();
            this.addLastFrameBonus(input, i,frame);
        } else if ( isSpare(firstThrow, secondThrow)) {
            frame = SpareFrame.create(parse(firstThrow), 10 - parse(firstThrow));
            this.addLastFrameBonus(input,i,frame);
        }
        return frame;
    }


    private void addLastFrameBonus(String input, int indexOfCurrentThrow, Frame lastFrame) {
        Integer numberOfBonusesAwarded = lastFrame instanceof SpikeFrame ? 2 : 1;

        for (int j = 0; j < numberOfBonusesAwarded; j++) {
            String bonusBall;
            if (lastFrame instanceof SpikeFrame) {
                bonusBall = String.valueOf(input.charAt(indexOfCurrentThrow));
            } else {
                bonusBall = String.valueOf(input.charAt(input.length() -1 ));
            }
            lastFrame.getBonusBall().add(parse(bonusBall));
            indexOfCurrentThrow++;
        }
    }
}