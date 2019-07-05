package org.codingdojo.bowling.business;

import java.util.List;

import static org.codingdojo.bowling.business.Frame.TOTAL_PIN;

public class ScoreService {

    public static final Integer NB_FRAME = 10;

    private Integer score = 0;

    public Integer calculateScore(List<Frame> frames) {

        Integer currentFrame = 1;
        Integer indexOfFrame = 0;

        for (Frame frame : frames) {

            if (currentFrame > NB_FRAME) {
                this.score += this.bonusPointsCalculation(frame);
                break;
            }
            if (frame.isSpike())
                this.score += this.spikeFrameScore(frames, indexOfFrame, currentFrame);

            if (frame.isSpare())
                this.score += this.spareFrameScore(frames, indexOfFrame, currentFrame);

            if (frame.isOpen())
                this.score += this.openFrameScore(frame);

            currentFrame++;
            indexOfFrame++;
        }

        this.score.intValue();
        return this.score;
    }

    protected int bonusPointsCalculation(Frame frame) {

        if (frame.isSpare())
            return frame.firstThrow;

        return 0;

    }

    public Integer openFrameScore(Frame frame) {

        return frame.getFirstThrow() + frame.getSecondThrow();
    }


    public Integer spikeFrameScore(List<Frame> frames, Integer indexOfFrame, Integer currentFrame) {

        int score = 0;

        if (currentFrame < frames.size()) {
            Frame nextFrame = frames.get(indexOfFrame + 1);
            if (nextFrame.isSpike() && (indexOfFrame + 2) < frames.size() - 1) {
                score += TOTAL_PIN + TOTAL_PIN + frames.get(indexOfFrame + 2).getFirstThrow();
            } else score += TOTAL_PIN + nextFrame.getFirstThrow() + nextFrame.getSecondThrow();
        }

        if (currentFrame.equals(frames.size())) {
            Frame frame = frames.get(indexOfFrame);
            score += bonusPointsCalculation(frame);
        }

        return score;
    }


    public Integer spareFrameScore(List<Frame> frames, Integer indexOfFrame, Integer currentFrame) {

        int score = 0;

        if (currentFrame < frames.size()) {
            Frame nextFrame = frames.get(indexOfFrame + 1);
            score += TOTAL_PIN + nextFrame.getFirstThrow();
        }

        if (currentFrame.equals(frames.size())) {
            Frame frame = frames.get(indexOfFrame);
            score += bonusPointsCalculation(frame);
        }

        return score;
    }


}
