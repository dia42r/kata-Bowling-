package org.codingdojo.bowling;

import lombok.extern.slf4j.Slf4j;
import org.codingdojo.bowling.business.*;

import java.util.*;

import static org.codingdojo.bowling.business.Frame.TOTAL_PIN;
import static org.codingdojo.bowling.helper.FrameHelper.*;

@Slf4j
public class BowlingScoreCalculation {

    private List<Frame> frames;
    private ScoreService scoreService;


    public BowlingScoreCalculation(ScoreService scoreService) {

        this.scoreService = scoreService;
        this.frames = new ArrayList<>();
    }


    public Integer getScore(String input) {

        List<Frame> frames = this.createFrames(input);
        return this.scoreService.calculateScore(frames);
    }


    private List<Frame> createFrames( String input) {

        Integer firstThrow;
        Integer secondThrow;
        Frame frame = Frame.create(0,0);
        input = input.replaceAll("\\s","");

        for (int i = 0; i < input.length(); i++) {

            firstThrow = Integer.valueOf(String.valueOf(parse(String.valueOf(input.charAt(i)))));

            if (firstThrow.equals(TOTAL_PIN)) {
                frame = Frame.create(firstThrow,firstThrow);
                this.frames.add(frame);
                continue;
            }

            secondThrow = Integer.valueOf((i < input.length() - 1) ?
                    String.valueOf(parse(String.valueOf(input.charAt(i + 1)))) : "0");

            if (secondThrow.equals(TOTAL_PIN)) {
                frame = Frame.create(firstThrow, TOTAL_PIN - firstThrow);
                i++;
            }  else if ((firstThrow +  secondThrow) < TOTAL_PIN) {
                frame = Frame.create(firstThrow, secondThrow);
                i++;
            }

            this.frames.add(frame);
        }

        this.logInput();

        return this.frames;
    }


    private void logInput() {
        this.frames.forEach(el -> {
            log.info("[ {} , {}, {}]", el.getFirstThrow(), el.getSecondThrow(), el.getBonusBall().toString());
        });
    }
}