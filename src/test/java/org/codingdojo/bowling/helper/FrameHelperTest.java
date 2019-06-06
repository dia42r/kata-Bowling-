package org.codingdojo.bowling.helper;

import org.junit.Test;

import static org.junit.Assert.*;

public class FrameHelperTest {

    @Test
    public void isSpike() {
        assertTrue(FrameHelper.isSpike("X"));
        assertFalse(FrameHelper.isSpike("-"));
        assertFalse(FrameHelper.isSpike("/"));
    }

    @Test
    public void isSpare() {

        assertTrue(FrameHelper.isSpare("7","/"));
        assertFalse(FrameHelper.isSpare("-","4"));
        assertFalse(FrameHelper.isSpare("3","3"));
    }

    @Test
    public void isOpen() {

        assertTrue(FrameHelper.isOpen("7","1"));
    }

    @Test
    public void isInteger() {
        assertTrue(FrameHelper.isInteger("2"));
        assertFalse(FrameHelper.isInteger("A"));

    }

    @Test
    public void parse() {

        assertEquals(Integer.valueOf(10), FrameHelper.parse("X"));
        assertEquals(Integer.valueOf(0), FrameHelper.parse("-"));
        assertEquals(Integer.valueOf(3), FrameHelper.parse("3"));

        try {
            FrameHelper.parse("Z");
        } catch (IllegalArgumentException e) {
            assert(e.getMessage().contains("can't parse this entry"));
        }

        assertEquals(Integer.valueOf(10), FrameHelper.parse("X"));
        assertEquals(Integer.valueOf(10), FrameHelper.parse("X"));
        assertEquals(Integer.valueOf(10), FrameHelper.parse("X"));
    }
}