import lombok.extern.slf4j.Slf4j;
import org.codingdojo.bowling.BowlingScoreCalculation;
import org.codingdojo.bowling.ConsoleReader;
import org.codingdojo.bowling.business.ScoreService;

@Slf4j
public class MainApp {

    public static void main(String[] args) {
        ConsoleReader reader = new ConsoleReader();
        String input = reader.read();
        BowlingScoreCalculation c = new BowlingScoreCalculation(new ScoreService());
        log.info(" Your Score : {}", c.getScore(input));
    }
}
