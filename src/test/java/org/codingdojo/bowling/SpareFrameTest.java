package org.codingdojo.bowling;

import org.codingdojo.bowling.business.Frame;
import org.codingdojo.bowling.business.OpenFrame;
import org.codingdojo.bowling.business.SpareFrame;
import org.codingdojo.bowling.business.SpikeFrame;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SpareFrameTest {

    @Test
    public void calculateScoreForSpareFrameFollowedByOpenFrame(){

        List<Frame> frames = new ArrayList<>();
        Frame spareFrame = SpareFrame.create(4,6);
        frames.add(spareFrame);
        frames.add(OpenFrame.create(5,2));

        assertEquals(Integer.valueOf(15), spareFrame.calculate(frames,0,1));
    }

    @Test
    public void calculateScoreForSpareFrameFollowedBySpikeFrame(){

        List<Frame> frames = new ArrayList<>();
        Frame spareFrame = SpareFrame.create(4,6);
        frames.add(spareFrame);
        frames.add(SpikeFrame.create());

        assertEquals(Integer.valueOf(20), spareFrame.calculate(frames,0,1));
    }


    @Test
    public void shouldThrowIllegalArgumentExceptionWhenCreateSpareFrameWithInvalidValues() {
        try {
            Frame frame = OpenFrame.create(2, 1);
        } catch (IllegalArgumentException e) {
            assert(e.getMessage().contains("Spare frame score must be equals to 10"));
        }
    }
}