package org.codingdojo.bowling.business;

import java.util.List;

public class SpareFrame extends Frame {

    private SpareFrame(Integer firstThrow, Integer secondThrow) {
        super(firstThrow, secondThrow);
    }


    public static Frame create(Integer firstThrow, Integer secondThrow) {
        if ((firstThrow + secondThrow) != 10) throw  new IllegalArgumentException(" Spare frame score must be equals to 10 ");
        return new SpareFrame(firstThrow, secondThrow);
    }

    @Override
    public Integer calculate(List<Frame> frames, Integer indexOfFrame, Integer currentFrame) {
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
