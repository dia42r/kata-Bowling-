package org.codingdojo.bowling;

import java.util.List;

public class Game {

    private static final Integer NB_MAX_PIN = 10;
    private static final Integer NB_FRAME = 10;

    private Integer score = 0;
    private Integer bonusBall = 0;

    public Integer getScore(List<Frame> frames) {

        Integer currentFrame = 1;
        Integer indexOfFrame = 0;
        for (Frame frame : frames) {

            if (frame.isStrike() && currentFrame < NB_FRAME) {

                Frame nextFrame = frames.get(indexOfFrame + 1);

                if (nextFrame.isStrike() && (indexOfFrame + 2) < frames.size() - 1) {
                    this.score += NB_MAX_PIN + NB_MAX_PIN + frames.get(indexOfFrame + 2).getFirstThrow();
                } else {
                    this.score += NB_MAX_PIN + nextFrame.getFirstThrow() + nextFrame.getSecondThrow();
                }

            } else if (frame.isStrike() && currentFrame.equals(NB_FRAME)) {
                this.bonusBall = frame.getBonusBall().stream().reduce(0, (a, b) -> (a + b));
                this.score += NB_MAX_PIN + this.bonusBall;

            } else if (frame.isSpare() && currentFrame < NB_FRAME) {

                Frame nextFrame = frames.get(indexOfFrame + 1);
                this.score += NB_MAX_PIN + nextFrame.getFirstThrow();

            } else if (frame.isSpare() && currentFrame.equals(NB_FRAME)) {

                this.bonusBall = frame.getBonusBall().stream().reduce(0, (a, b) -> (a + b));
                this.score += NB_MAX_PIN + this.bonusBall;

            } else if (frame.isOpen()){
                this.score += frame.getFirstThrow() + frame.getSecondThrow();
            } else {
                throw new IllegalArgumentException("Invalid Frame : Throw must be between [0 - 10]") ;
            }

            currentFrame++;
            indexOfFrame++;
        }

        return this.score;
    }
}
