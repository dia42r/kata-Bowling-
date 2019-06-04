package org.codingdojo.bowling;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@Slf4j
public class Console implements Customer {

    @Override
    public void run() {
        Game game = new Game();
        List<Frame> frames = new ArrayList<>();

        for (int i = 1; i <= Game.NB_FRAME; i++) {
            log.info(" ** Frame " + i + " ********************************************************************************* ");

            Scanner scanner = new Scanner(System.in);

            Integer aTry_1 = this.readEntry(i,1,scanner);

            log.info(" == " + aTry_1);

            if (aTry_1.equals(Game.NB_MAX_PIN)) {
                log.info(" ** Strike ! **");
                Frame frame = new Frame(10,10);
                frames.add(frame);

                if (i == Game.NB_FRAME) {
                    this.spikeBonus(scanner, frame);
                }

                continue;
            }

            Integer aTry_2 = this.readEntry(i,2,scanner);

            Frame frame = new Frame(aTry_1, aTry_2);

            if (aTry_1 + aTry_2 == Game.NB_MAX_PIN) {
                log.info(" ** Spare ! **");

                if (i == Game.NB_FRAME) {
                    this.spareBonus(scanner, frame);
                }
            }

            frames.add(frame);
        }

        frames.forEach(frame -> log.info("[" +frame.getFirstThrow() + ", " + frame.getSecondThrow() + "]" ));

        log.info(" Your Score : " + game.getScore(frames));
    }

    private Integer readEntry(Integer frameNumber, Integer tryNumber , Scanner scanner) {

        log.info(" **** Try " + tryNumber +" : Number between [0 - 10] for number of pin down ** ");

        boolean valide = false;
        Integer entry = null;
        while(!valide) {
            try {
                entry = scanner.nextInt();
                valide = isValideEntry(entry);

                if (!valide) {

                    log.error("Number must be between [0 - 10]");
                }
            } catch (InputMismatchException e) {
                log.error(" Entry must be Integer :  ");
                scanner.next();
            }
        }
        return entry;
    }


    private boolean isValideEntry(Integer entry) {
        return entry <= 10;
    }

    private void spikeBonus(Scanner scanner, Frame frame) {
        log.info(" **** You have 2 Bonus Ball : Number between [0 - 10] for number of pin down ** ");
        log.info(" **** Bonus 1 Try  : Number between [0 - 10] for number of pin down ** ");
        Integer bonus1 = scanner.nextInt();

        log.info(" **** Bonus 2 Try  : Number between [0 - 10] for number of pin down ** ");
        Integer bonus2 = scanner.nextInt();

        frame.getBonusBall().add(bonus1);
        frame.getBonusBall().add(bonus2);
    }

    private void spareBonus(Scanner scanner, Frame frame) {
        log.info(" ****** You have 1 Bonus Ball : Number between [0 - 10] for number of pin down ** ");
        log.info(" ****** Bonus 1 Try  : Number between [0 - 10] for number of pin down ** ");

        Integer bonus1 = scanner.nextInt();
        frame.getBonusBall().add(bonus1);
    }

}
