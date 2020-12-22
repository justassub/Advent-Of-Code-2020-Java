package lt.justassub.adventofcode.year2020.day22;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WarGame {
    private final Player player1;
    private final Player player2;

    public Player playGame() {
        while (!player1.getCards().isEmpty() && !player2.getCards().isEmpty()) {
            Integer player1Card = extractNextCard(player1);
            Integer player2Card = extractNextCard(player2);

            if (player1Card > player2Card) {
                player1.addCards(player1Card, player2Card);
            } else if (player1Card < player2Card) {
                player2.addCards(player2Card, player1Card);
            } else {
                throw new NotSupportedOperation("Not Supported operation.");
            }
        }
        return player1.getCards().isEmpty() ? player2 : player1;
    }

    private Integer extractNextCard(Player player) {
        return player.getCards().removeFirst();
    }

    static class NotSupportedOperation extends RuntimeException {
        NotSupportedOperation(String message) {
            super(message);
        }
    }
}
