package lt.justassub.adventofcode.year2020.day23;

import org.junit.Test;

import java.util.LinkedList;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toCollection;
import static org.assertj.core.api.Assertions.assertThat;

public class CupGameTest {
    LinkedList<Integer> innitialNumbers = Stream.of(3, 8, 9, 1, 2, 5, 4, 6, 7).collect(toCollection(LinkedList::new));

    @Test
    public void playOneRound() {
        CupGame cupGame = new CupGame(1, innitialNumbers);
        LinkedList<Integer> result = cupGame.playGame();
        assertThat(result)
                .hasSize(9)
                .containsExactly(2, 8, 9, 1, 5, 4, 6, 7, 3);
    }

    @Test
    public void playTwoRounds() {
        CupGame cupGame = new CupGame(2, innitialNumbers);
        LinkedList<Integer> result = cupGame.playGame();
        assertThat(result)
                .hasSize(9)
                .containsExactly(5, 4, 6, 7, 8, 9, 1, 3, 2);
    }

    @Test
    public void playTenRounds() {
        CupGame cupGame = new CupGame(10, innitialNumbers);
        LinkedList<Integer> result = cupGame.playGame();
        assertThat(result)
                .hasSize(9)
                .containsExactly(8, 3, 7, 4, 1, 9, 2, 6, 5);
    }
}
