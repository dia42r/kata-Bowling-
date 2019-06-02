package org.codingdojo.bowling;

import lombok.Data;

@Data
public class Frame {

    private Integer firstThrow;
    private Integer secondThrow;

    public Frame(Integer firstThrow, Integer secondThrow) {
        this.firstThrow = firstThrow;
        this.secondThrow = secondThrow;
    }

    public boolean isStrike() {
        return this.getFirstThrow().equals(10);
    }

}
