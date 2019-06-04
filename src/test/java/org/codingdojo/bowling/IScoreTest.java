package org.codingdojo.bowling;

import org.codingdojo.bowling.business.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Integration Test
 */
@RunWith(MockitoJUnitRunner.class)
public class IScoreTest {

    /**
     * scoring “X” indicates a strike, “/” indicates a spare, “-” indicates a miss)
     */

    /**
     * X X X X X X X X X X X X (12 rolls: 12 strikes) = 10 frames * 30 points = 300
     */


    @Test
    public void shouldReturnPerfectGameScore() {
        Score score = new Score();
        List<Frame> frames = new ArrayList<>();


        frames.add(SpikeFrame.create());
        frames.add(SpikeFrame.create());
        frames.add(SpikeFrame.create());
        frames.add(SpikeFrame.create());
        frames.add(SpikeFrame.create());
        frames.add(SpikeFrame.create());
        frames.add(SpikeFrame.create());
        frames.add(SpikeFrame.create());
        frames.add(SpikeFrame.create());
        Frame lastFrame = SpikeFrame.create();
        lastFrame.getBonusBall().add(10);
        lastFrame.getBonusBall().add(10);
        frames.add(lastFrame);

        assertEquals(Integer.valueOf(300), score.score(frames));
    }

    /**
     * 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/5 (21 rolls: 10 pairs of 5 and spare, with a final 5) = 10 frames * 15 points = 150
     */

    @Test
    public void shouldReturnSparesScore() {

        Score score = new Score();

        List<Frame> frames = new ArrayList<>();
        frames.add(SpareFrame.create(5,5));
        frames.add(SpareFrame.create(5,5));
        frames.add(SpareFrame.create(5,5));
        frames.add(SpareFrame.create(5,5));
        frames.add(SpareFrame.create(5,5));
        frames.add(SpareFrame.create(5,5));
        frames.add(SpareFrame.create(5,5));
        frames.add(SpareFrame.create(5,5));
        frames.add(SpareFrame.create(5,5));

        Frame lastFrame = SpareFrame.create(5,5);
        lastFrame.getBonusBall().add(5);
        frames.add(lastFrame);

        assertEquals(Integer.valueOf(150), score.score(frames));
    }
    /**
     * X 7/	7 2	9/ X X X 2 3 6/ 7/3  = 20 + 17 + 9 + 20 + 30 + 22 + 15 + 5 + 17 + 13 = 168
     */

    @Test
    public void shouldReturnMixedFrameScore() {

        Score score = new Score();

        List<Frame> frames = new ArrayList<>();
        frames.add(SpikeFrame.create());
        frames.add(SpareFrame.create(7,3));
        frames.add(OpenFrame.create(7,2));
        frames.add(SpareFrame.create(9,1));
        frames.add(SpikeFrame.create());
        frames.add(SpikeFrame.create());
        frames.add(SpikeFrame.create());
        frames.add(OpenFrame.create(2,3));
        frames.add(SpareFrame.create(6,4));
        Frame lastFrame = SpareFrame.create(7,3);
        lastFrame.getBonusBall().add(3);
        frames.add(lastFrame);

        assertEquals(Integer.valueOf(168), score.score(frames));
    }

    /**
     * 9- 9- 9- 9- 9- 9- 9- 9- 9- 9- (20 rolls: 10 pairs of 9 and miss) = 10 frames * 9 points = 90
     */
    @Test
    public void shouldReturnOpenFrameScore() {

        Score score = new Score();

        List<Frame> frames = new ArrayList<>();
        frames.add(OpenFrame.create(9,0));
        frames.add(OpenFrame.create(9,0));
        frames.add(OpenFrame.create(9,0));
        frames.add(OpenFrame.create(9,0));
        frames.add(OpenFrame.create(9,0));
        frames.add(OpenFrame.create(9,0));
        frames.add(OpenFrame.create(9,0));
        frames.add(OpenFrame.create(9,0));
        frames.add(OpenFrame.create(9,0));
        frames.add(OpenFrame.create(9,0));

        assertEquals(Integer.valueOf(90), score.score(frames));
    }
}