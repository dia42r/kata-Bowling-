package org.codingdojo.bowling;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class GameTest {

    /**
     * scoring “X” indicates a strike, “/” indicates a spare, “-” indicates a miss)
     */

    /**
     * X X X X X X X X X X X X (12 rolls: 12 strikes) = 10 frames * 30 points = 300
     */
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

        Frame lastFrame = new Frame(10,10);
        lastFrame.getBonusBall().add(10);
        lastFrame.getBonusBall().add(10);
        frames.add(lastFrame);

        assertEquals(Integer.valueOf(300), game.getScore(frames));
    }


    /**
     * 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/5 (21 rolls: 10 pairs of 5 and spare, with a final 5) = 10 frames * 15 points = 150
     */
    @Test
    public void Should_Return_Spares_Score() {

        Game game= new Game();

        List<Frame> frames = new ArrayList<Frame>();
        frames.add(new Frame(5,5));
        frames.add(new Frame(5,5));
        frames.add(new Frame(5,5));
        frames.add(new Frame(5,5));
        frames.add(new Frame(5,5));
        frames.add(new Frame(5,5));
        frames.add(new Frame(5,5));
        frames.add(new Frame(5,5));
        frames.add(new Frame(5,5));
        Frame lastFrame = new Frame(5,5);
        lastFrame.getBonusBall().add(5);
        frames.add(lastFrame);

        assertEquals(Integer.valueOf(150), game.getScore(frames));
    }

    /**
     * X 7/	7 2	9/ X X X 2 3 6/ 7/3  = 20 + 17 + 9 + 20 + 30 + 22 + 15 + 5 + 17 + 13 = 168
     */
    @Test
    public void Should_Return_Mixed_Frame_Score() {

        Game game= new Game();

        List<Frame> frames = new ArrayList<Frame>();
        frames.add(new Frame(10,10));
        frames.add(new Frame(7,3));
        frames.add(new Frame(7,2));
        frames.add(new Frame(9,1));
        frames.add(new Frame(10,10));
        frames.add(new Frame(10,10));
        frames.add(new Frame(10,10));
        frames.add(new Frame(2,3));
        frames.add(new Frame(6,4));
        Frame lastFrame = new Frame(7,3);
        lastFrame.getBonusBall().add(3);
        frames.add(lastFrame);

        assertEquals(Integer.valueOf(168), game.getScore(frames));
    }

    /**
     * 9- 9- 9- 9- 9- 9- 9- 9- 9- 9- (20 rolls: 10 pairs of 9 and miss) = 10 frames * 9 points = 90
     */
    @Test
    public void Should_Return_Open_Frame_Score() {

        Game game= new Game();

        List<Frame> frames = new ArrayList<Frame>();
        frames.add(new Frame(9,0));
        frames.add(new Frame(9,0));
        frames.add(new Frame(9,0));
        frames.add(new Frame(9,0));
        frames.add(new Frame(9,0));
        frames.add(new Frame(9,0));
        frames.add(new Frame(9,0));
        frames.add(new Frame(9,0));
        frames.add(new Frame(9,0));
        frames.add(new Frame(9,0));

        assertEquals(Integer.valueOf(90), game.getScore(frames));
    }

    @Test
    public void Must_Throw_IllegalArgumentException() {

        Game game= new Game();

        List<Frame> frames = new ArrayList<Frame>();
        frames.add(new Frame(8,2));
        frames.add(new Frame(5,4));
        frames.add(new Frame(9,0));
        frames.add(new Frame(10,10));
        frames.add(new Frame(10,10));
        frames.add(new Frame(5,5));
        frames.add(new Frame(5,3));
        frames.add(new Frame(6,3));
        frames.add(new Frame(0,12));
        Frame lastFrame = new Frame(9,1);
        lastFrame.getBonusBall().add(10);
        frames.add(lastFrame);

        try {
            game.getScore(frames);
        } catch (IllegalArgumentException e) {
            assert(e.getMessage().contains("Invalid Frame : Throw must be between [0 - 10]"));
        }
    }
}