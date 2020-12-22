package lt.justassub.adventofcode.year2020.day22;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WarGameTest {
    private Player player1 = new Player("First");
    private Player player2 = new Player("Second");
    private WarGame warGame = new WarGame(player1, player2);

    @Test
    public void simpleOneRoundMatchWinsFirst() {
        player1.addCards(5);
        player2.addCards(3);
        warGame.playGame();
        assertThat(player1.getCards())
                .hasSize(2);
        assertThat(player2.getCards())
                .isEmpty();
        assertThat(player1.getCards())
                .containsExactly(5, 3);
    }

    @Test
    public void simpleOneRoundMatchWinsSecond() {
        player1.addCards(4);
        player2.addCards(8);
        warGame.playGame();
        assertThat(player1.getCards())
                .isEmpty();
        assertThat(player2.getCards())
                .hasSize(2);
        assertThat(player2.getCards())
                .containsExactly(8, 4);
    }

    @Test
    public void simpleTwoRoundsWinsFirst() {
        player1.addCards(5, 4);
        player2.addCards(3, 2);
        warGame.playGame();
        assertThat(player1.getCards())
                .hasSize(4);
        assertThat(player2.getCards())
                .isEmpty();
        assertThat(player1.getCards())
                .containsExactly(5, 3, 4, 2);
    }

    @Test
    public void part1Example1() {
        player1.addCards(9, 2, 6, 3, 1);
        player2.addCards(5, 8, 4, 7, 10);
        warGame.playGame();
        assertThat(player1.getCards())
                .isEmpty();
        assertThat(player2.getCards())
                .hasSize(10);
        assertThat(player2.getCards())
                .containsExactly(3, 2, 10, 6, 8, 5, 9, 4, 7, 1);
    }
}
