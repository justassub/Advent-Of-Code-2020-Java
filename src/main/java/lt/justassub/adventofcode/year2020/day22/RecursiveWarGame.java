package lt.justassub.adventofcode.year2020.day22;

import lombok.AllArgsConstructor;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

@AllArgsConstructor
public class RecursiveWarGame {
    private final Player player1;
    private final Player player2;

    public Player playRecursive() {
        Set<Set<LinkedList<Integer>>> history = new HashSet<>();
        while (!player1.getCards().isEmpty() && !player2.getCards().isEmpty()) {
            if (!history.add(Set.of(player1.getCards(), player2.getCards()))) {
                return player1;
            }
            Integer player1Card = extractNextCard(player1);
            Integer player2Card = extractNextCard(player2);
            if (player1.getCards().size() >= player1Card && player2.getCards().size() >= player2Card) {
                LinkedList<Integer> sublist1 = new LinkedList<>(player1.getCards().subList(0, player1Card));
                LinkedList<Integer> sublist2 = new LinkedList<>(player2.getCards().subList(0, player2Card));
                Player newPlayer1 = new Player(player1.getName(), sublist1);
                Player newPlayer2 = new Player(player2.getName(), sublist2);

                RecursiveWarGame newRecursiveWarGame = new RecursiveWarGame(newPlayer1, newPlayer2);
                Player winner = newRecursiveWarGame.playRecursive();
                if (winner.getName().equals(player1.getName())) {
                    player1.addCards(player1Card, player2Card);
                } else {
                    player2.addCards(player2Card, player1Card);
                }
            } else {
                if (player1Card > player2Card) {
                    player1.addCards(player1Card, player2Card);
                } else if (player1Card < player2Card) {
                    player2.addCards(player2Card, player1Card);
                } else {
                    throw new WarGame.NotSupportedOperation("Not Supported operation.");
                }
            }
        }
        return player1.getCards().isEmpty() ? player2 : player1;
    }

    private static Integer extractNextCard(Player player) {
        return player.getCards().removeFirst();
    }

}
