package org.codingdojo.bowling;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console implements Customer {

    @Override
    public void run() {
        Game game = new Game();
        List<Frame> frames = new ArrayList<>();

        for (int i = 1; i <= Game.NB_FRAME; i++) {

            System.out.println(" ** Frame " + i + " ********************************************************************************* ");
            System.out.println(" **** Try 1 : Number between [0 - 10] for number of pin down ** ");
            Scanner scanner = new Scanner(System.in);
            Integer aTry_1 = scanner.nextInt();
            System.out.println(" == " + aTry_1);

            if (aTry_1 == Game.NB_MAX_PIN) {
                System.out.println(" ** Strike ! **");
                Frame frame = new Frame(10,10);
                frames.add(frame);

                if (i == Game.NB_FRAME) {
                    System.out.println(" **** You have 2 Bonus Ball : Number between [0 - 10] for number of pin down ** ");
                    System.out.println(" **** Bonus 1 Try  : Number between [0 - 10] for number of pin down ** ");
                    Integer bonus1 = scanner.nextInt();

                    System.out.println(" **** Bonus 2 Try  : Number between [0 - 10] for number of pin down ** ");
                    Integer bonus2 = scanner.nextInt();

                    frame.getBonusBall().add(bonus1);
                    frame.getBonusBall().add(bonus2);
                }

                continue;
            }

            System.out.println(" **** Try 2 : Number between [0 - 10] for number of pin down ** ");
            Integer aTry_2 = scanner.nextInt();

            Frame frame = new Frame(aTry_1, aTry_2);

            if (Integer.valueOf(aTry_1) + Integer.valueOf(aTry_2) == Game.NB_MAX_PIN) {
                System.out.println(" ** Spare ! **");

                if (i == Game.NB_FRAME) {
                    System.out.println(" ****** You have 1 Bonus Ball : Number between [0 - 10] for number of pin down ** ");
                    System.out.println(" ****** Bonus 1 Try  : Number between [0 - 10] for number of pin down ** ");

                    Integer bonus1 = scanner.nextInt();
                    frame.getBonusBall().add(bonus1);
                }
            }

            frames.add(frame);
        }

        frames.forEach(frame -> {
            System.out.println("[" +frame.getFirstThrow() + ", " + frame.getSecondThrow() + "]" );
        });

        System.out.println(" Your Score : " + game.getScore(frames));
    }
}
