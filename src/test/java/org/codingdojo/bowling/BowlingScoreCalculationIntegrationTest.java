package org.codingdojo.bowling;

import org.codingdojo.bowling.business.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Integration Test
 */
public class BowlingScoreCalculationIntegrationTest {

    /**
     * scoring “X” indicates a strike, “/” indicates a spare, “-” indicates a miss)
     */

    /**
     * X X X X X X X X X X X X (12 rolls: 12 strikes) = 10 frames * 30 points = 300
     */


    @Test
    public void shouldReturnPerfectGameScore() {

        ScoreService scoreService = new ScoreService();
        String input = "XXXXXXXXXXXX";
        BowlingScoreCalculation bowlingScoreCalculation = new BowlingScoreCalculation(scoreService);

        assertEquals(Integer.valueOf(300),  bowlingScoreCalculation.getScore(input));

    }

    /**
     * 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/5 (21 rolls: 10 pairs of 5 and spare, with a final 5) = 10 frames * 15 points = 150
     */

    @Test
    public void shouldReturnSparesScore() {

        ScoreService scoreService = new ScoreService();
        String input = "5/5/5/5/5/5/5/5/5/5/5";
        BowlingScoreCalculation bowlingScoreCalculation = new BowlingScoreCalculation(scoreService);

        assertEquals(Integer.valueOf(150),  bowlingScoreCalculation.getScore(input));

    }

    /**
     * X 7/	7 2	9/ X X X 2 3 6/ 7/3  = 20 + 17 + 9 + 20 + 30 + 22 + 15 + 5 + 17 + 13 = 168
     */
    @Test
    public void shouldReturnMixedFrameScore() {

        ScoreService scoreService = new ScoreService();
        String input = "X7/729/XXX236/7/3";
        BowlingScoreCalculation bowlingScoreCalculation = new BowlingScoreCalculation(scoreService);

        assertEquals(Integer.valueOf(168),  bowlingScoreCalculation.getScore(input));
    }

    /**
     * 9- 9- 9- 9- 9- 9- 9- 9- 9- 9- (20 rolls: 10 pairs of 9 and miss) = 10 frames * 9 points = 90
     */
    @Test
    public void shouldReturnFrameScore() {

        ScoreService scoreService = new ScoreService();
        String input = "9-9-9-9-9-9-9-9-9-9-";
        BowlingScoreCalculation bowlingScoreCalculation = new BowlingScoreCalculation(scoreService);

        assertEquals(Integer.valueOf(90),  bowlingScoreCalculation.getScore(input));
    }
}