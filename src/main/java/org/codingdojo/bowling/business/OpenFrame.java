package org.codingdojo.bowling.business;

import java.util.List;

public class OpenFrame extends Frame {

    private OpenFrame(Integer firstThrow, Integer secondThrow) {
        super(firstThrow, secondThrow);
    }


    public static Frame create(Integer firstThrow, Integer secondThrow) {
        if ((firstThrow + secondThrow) > TOTAL_PIN ) throw new IllegalArgumentException(" Open frame score must be less than 10");
        return new OpenFrame(firstThrow, secondThrow);
    }


    public Integer calculate(List<Frame> frames, Integer indexOfFrame, Integer currentFrame) {
        Frame frame = frames.get(indexOfFrame);
        return frame.getFirstThrow() + frame.getSecondThrow();
    }
}
