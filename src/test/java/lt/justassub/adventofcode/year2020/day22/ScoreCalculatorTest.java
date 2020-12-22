package lt.justassub.adventofcode.year2020.day22;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ScoreCalculatorTest {
    Player player1 = new Player("Test1");
    Player player2 = new Player("Test2");
    List<Player> playerList = asList(player1, player2);
    ScoreCalculator scoreCalculator = new ScoreCalculator(playerList);

    @Test
    public void calculateOnePlayerScoreCorrectly() {
        player1.addCards(1);
        assertThat(scoreCalculator.calculateScores()).isEqualTo(1);
    }

    @Test
    public void calculateOnePlayerScoreCorrectlyMoreScores() {
        player1.addCards(1, 2, 3, 4, 5);
        assertThat(scoreCalculator.calculateScores()).isEqualTo(35);
    }

    @Test
    public void calculateOnePlayerMultipleScores() {
        player1.addCards(1, 2, 3, 4, 5);
        player2.addCards(1, 3);
        assertThat(scoreCalculator.calculateScores()).isEqualTo(40);
    }
}
