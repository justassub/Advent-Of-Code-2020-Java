package lt.justassub.adventofcode.year2020.day22;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WarGame {
    private Player player1;
    private Player player2;

    public void playGame() {
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
    }

    private Integer extractNextCard(Player player) {
        return player.getCards().removeFirst();
    }

    private static class NotSupportedOperation extends RuntimeException {
        private NotSupportedOperation(String message) {
            super(message);
        }
    }
}
