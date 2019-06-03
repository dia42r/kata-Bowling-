package org.codingdojo.bowling;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Frame {

    private static final int NB_MAX_PIN = 10;
    private Integer firstThrow;
    private Integer secondThrow;
    private ArrayList<Integer> bonusBall;

    public Frame(Integer firstThrow, Integer secondThrow) {
        this.firstThrow = firstThrow;
        this.secondThrow = secondThrow;
        this.bonusBall = new ArrayList<>();
    }

    public boolean isStrike() {
        return this.getFirstThrow().equals(NB_MAX_PIN);
    }

    public boolean isSpare() {
        return (this.getFirstThrow() + this.getSecondThrow()) == NB_MAX_PIN;
    }

    public boolean isOpen() {
        return (this.getFirstThrow() + this.getSecondThrow()) < NB_MAX_PIN;
    }
}
