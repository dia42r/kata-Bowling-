package org.codingdojo.bowling;

import org.codingdojo.bowling.business.Frame;
import org.codingdojo.bowling.business.OpenFrame;
import org.codingdojo.bowling.business.SpareFrame;
import org.codingdojo.bowling.business.SpikeFrame;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SpikeFrameTest {

    @Test
    public void calculateScoreForSpikeFrameFollowedBySpareFrame(){

        List<Frame> frames = new ArrayList<>();
        Frame spikeFrame = SpikeFrame.create();
        frames.add(spikeFrame);
        frames.add(SpareFrame.create(5,5));
        frames.add(OpenFrame.create(5,3));

        assertEquals(Integer.valueOf(20), spikeFrame.calculate(frames,0,1));
    }
    @Test
    public void calculateScoreForSpikeFrameFollowedByOpenFrame(){

        List<Frame> frames = new ArrayList<>();
        Frame spikeFrame = SpikeFrame.create();
        frames.add(spikeFrame);
        frames.add(OpenFrame.create(2,3));

        assertEquals(Integer.valueOf(15), spikeFrame.calculate(frames,0,1));
    }

    @Test
    public void calculateScoreForSuccessiveTreeSpikeFrame(){

        List<Frame> frames = new ArrayList<>();
        Frame spikeFrame = SpikeFrame.create();
        frames.add(spikeFrame);
        frames.add(SpikeFrame.create());
        frames.add(SpikeFrame.create());

        assertEquals(Integer.valueOf(30), spikeFrame.calculate(frames,0,1));
    }

}