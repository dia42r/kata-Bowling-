package org.codingdojo.bowling;

import org.codingdojo.bowling.business.Frame;
import org.codingdojo.bowling.business.OpenFrame;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class OpenFrameTest {

    @Test
    public void calculateScoreForOpenFrame() {
        Frame frame = OpenFrame.create(7, 0);
        List<Frame> frames = new ArrayList<>();
        frames.add(frame);
        assertEquals(Integer.valueOf(7), frame.calculate(frames, 0, 1));
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenCreateOpenFrameWithInvalidValues() {

        try {
            Frame frame = OpenFrame.create(2, 10);
        } catch (IllegalArgumentException e) {
            assert(e.getMessage().contains("Open frame score must be less than 10"));
        }
    }
}