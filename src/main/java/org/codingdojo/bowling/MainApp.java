package org.codingdojo.bowling;

import lombok.extern.slf4j.Slf4j;
import org.codingdojo.bowling.business.Score;

@Slf4j
public class MainApp {

    public static void main(String[] args) {
        ConsoleReader reader = new ConsoleReader();
        String input = reader.read();
        BowlingScoreCalculation c = new BowlingScoreCalculation(new Score(), input);
        log.info(" Your Score : {}", c.getScore());
    }
}
