package org.codingdojo.bowling;

import java.util.List;

public class Game {

    private Integer score = 0;
    private Integer nbFrame = 1;
    private Integer bonusBall = 0;

    public Integer getScore(List<Frame> frames) {

        for (Frame frame: frames) {
            if (frame.isStrike() && nbFrame < 10){
                Integer indexOfNextFrame = frames.indexOf(frame) + 1;
                Frame nextFrame = frames.get(indexOfNextFrame);
                this.score += 10 + nextFrame.getFirstThrow() + nextFrame.getSecondThrow();
            } else if (frame.isStrike() && nbFrame >= 10 ) {
                this.bonusBall += 10;
            }
        this.nbFrame++;
        }

        return this.score + this.bonusBall;
    }
}
