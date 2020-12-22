package lt.justassub.adventofcode.year2020.day22;

import org.junit.Assert;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class RecursiveWarGameTest {
    private Player player1 = new Player("First");
    private Player player2 = new Player("Second");
    RecursiveWarGame recursiveWarGame = new RecursiveWarGame(player1, player2);

    @Test
    public void part2Example2() {
        player1.addCards(9, 2, 6, 3, 1);
        player2.addCards(5, 8, 4, 7, 10);
        Player winner = recursiveWarGame.playRecursive();
        Assert.assertSame(winner, player2);
        assertThat(player1.getCards())
                .isEmpty();
        assertThat(winner.getCards())
                .containsExactly(7, 5, 6, 2, 4, 1, 10, 8, 9, 3);
    }

    @Test
    public void part2Example1Recursive() {
        player1.addCards(43, 19);
        player2.addCards(2, 29, 14);
        Player winner = recursiveWarGame.playRecursive();
        Assert.assertSame(winner, player1);
    }

}
