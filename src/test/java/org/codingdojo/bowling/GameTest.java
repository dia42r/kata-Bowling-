package org.codingdojo.bowling;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class GameTest {

    @Test
    public void Should_Return_Perfect_Game_Score() {
        Game game = new Game();
        List<Frame> frames = new ArrayList<Frame>();
        frames.add(new Frame(10,10));
        frames.add(new Frame(10,10));
        frames.add(new Frame(10,10));
        frames.add(new Frame(10,10));
        frames.add(new Frame(10,10));
        frames.add(new Frame(10,10));
        frames.add(new Frame(10,10));
        frames.add(new Frame(10,10));
        frames.add(new Frame(10,10));
        frames.add(new Frame(10,10));
        frames.add(new Frame(10,10));
        frames.add(new Frame(10,10));

        assertEquals(Integer.valueOf(300), game.getScore(frames));
    }
}