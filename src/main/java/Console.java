import org.codingdojo.bowling.Frame;
import org.codingdojo.bowling.Game;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Console {

    public void run() {
        Game game = new Game();
        Integer nbFrame = 10;
        List<Frame> frames = new ArrayList<>();

        for (int i = 1; i <= nbFrame; i++) {

            Scanner scanner = new Scanner(System.in);
            Integer aTry_1 = this.readEntry(i,1,  scanner);

            log.info(" == " + aTry_1);

            if (aTry_1.equals(10)) {
                log.info(" ** Strike ! **");
                Frame frame = new Frame(10,10);
                frames.add(frame);

                if (i == 10) {
                    spikeBonus(scanner, frame);
                }

                continue;
            }

            Integer aTry_2 = this.readEntry(i, 2,scanner);

            Frame frame = new Frame(aTry_1, aTry_2);

            if (aTry_1 + aTry_2 == 10) {
                log.info(" ** Spare ! **");

                if (i == 10) {
                    spareBonus(scanner, frame);
                }
            }

            frames.add(frame);
        }

        frames.forEach(frame -> log.info("[" +frame.getFirstThrow() + ", " + frame.getSecondThrow() + "]" ));

        log.info(" Your Score : " + game.getScore(frames));

    }

    private Integer readEntry(Integer frameNumber, Integer tryNumber, Scanner scanner) {
        Boolean valide = false;
        Integer entry = null;
        while (!valide) {
            log.info(" ** Frame " + frameNumber + " ********************************************************************************* ");
            log.info(" **** Try " + tryNumber + " : Number between [0 - 10] for number of pin down ** ");
            try {
                entry = scanner.nextInt();
                valide = true;
            } catch (IllegalArgumentException e) {
                log.info("Error : Number must be between [0 - 10]");
                valide = false;
            } catch (InputMismatchException exception) {
                log.info("Error : Number must be Integer [0 - 10]");
                valide = false;
            }
        }
        return entry;
    }

    private void spareBonus(Scanner scanner, Frame frame) {
        log.info(" ****** You have 1 Bonus Ball : Number between [0 - 10] for number of pin down ** ");
        log.info(" ****** Bonus 1 Try  : Number between [0 - 10] for number of pin down ** ");

        Integer bonus1 = scanner.nextInt();
        frame.getBonusBall().add(bonus1);
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
}
