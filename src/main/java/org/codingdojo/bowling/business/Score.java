package org.codingdojo.bowling.business;

import java.util.List;

public class Score {
    public static final Integer NB_FRAME = 10;

    private Integer score = 0;

    public Integer score(List<Frame> frames) {

        Integer currentFrame = 1;
        Integer indexOfFrame = 0;
        for (Frame frame : frames) {

            this.score += frame.calculate(frames,indexOfFrame, currentFrame);
            currentFrame++;
            indexOfFrame++;
        }

        return this.score;
    }
}
