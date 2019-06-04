package org.codingdojo.bowling.business;

import java.util.List;

public class SpikeFrame extends Frame {

    private SpikeFrame(Integer firstThrow, Integer secondThrow) {
        super(firstThrow, secondThrow);
    }


    public static Frame create() {
        return new SpikeFrame(TOTAL_PIN,TOTAL_PIN);
    }

    @Override
    public Integer calculate(List<Frame> frames, Integer indexOfFrame, Integer currentFrame) {
        int score = 0;
        if (currentFrame < frames.size()) {
            Frame nextFrame = frames.get(indexOfFrame + 1);
            if (nextFrame instanceof SpikeFrame && (indexOfFrame + 2) < frames.size() - 1) {
                score += TOTAL_PIN + TOTAL_PIN + frames.get(indexOfFrame + 2).getFirstThrow();
            } else score += TOTAL_PIN + nextFrame.getFirstThrow() + nextFrame.getSecondThrow();
        }

        if (currentFrame.equals(frames.size())) {
            Frame frame = frames.get(indexOfFrame);
            score += bonusPointsCalculation(frame);
        }
        return score;
    }

}
