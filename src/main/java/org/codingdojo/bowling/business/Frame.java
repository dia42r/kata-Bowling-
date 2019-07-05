package org.codingdojo.bowling.business;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Frame {

    public static final int TOTAL_PIN = 10;
    protected Integer firstThrow;
    protected Integer secondThrow;
    protected List<Integer> bonusBall;


    private Frame(Integer firstThrow, Integer secondThrow) {
        this.firstThrow = firstThrow;
        this.secondThrow = secondThrow;
        this.bonusBall = new ArrayList<>();
    }

    public static  Frame create(Integer firstThrow, Integer secondThrow) {

        Integer sumTries = firstThrow + secondThrow;

        if (firstThrow.equals(TOTAL_PIN)) {
            return new Frame(TOTAL_PIN,TOTAL_PIN);
        } else if (sumTries.equals(TOTAL_PIN) || sumTries < TOTAL_PIN ) {
            return new Frame(firstThrow,secondThrow);
        }
        else {
            throw new IllegalArgumentException(" Les lancés sont invalides ");
        }
    }

    public Boolean isSpike() {
        if (this.firstThrow.equals(TOTAL_PIN)) {
            return true;
        }
        return false;
    }


    public Boolean isSpare() {
        if (this.firstThrow + this.secondThrow == TOTAL_PIN) {
            return true;
        }
        return false;
    }


    public Boolean isOpen() {
        if (this.firstThrow + this.secondThrow < TOTAL_PIN) {
            return true;
        }
        return false;
    }
}
