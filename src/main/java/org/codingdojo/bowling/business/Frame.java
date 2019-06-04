package org.codingdojo.bowling.business;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public abstract class Frame {

    public static final int TOTAL_PIN = 10;
    protected Integer firstThrow;
    protected Integer secondThrow;
    protected ArrayList<Integer> bonusBall;


    protected Frame(Integer firstThrow, Integer secondThrow) {
        this.firstThrow = firstThrow;
        this.secondThrow = secondThrow;
        this.bonusBall = new ArrayList<>();
    }

    protected int bonusPointsCalculation(Frame frame) {
        int bonusBall = frame.getBonusBall().stream().reduce(0, (a, b) -> (a + b));
        return  TOTAL_PIN + bonusBall;
    }
    public abstract Integer calculate(List<Frame> frames, Integer indexOfFrame, Integer currentFrame);
}
