package lt.justassub.adventofcode.year2020.day22;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ScoreCalculator {
    private final List<Player> playerList;

    public long calculateScores() {
        return playerList.stream()
                .mapToLong(this::countScorePlayer)
                .sum();

    }

    private long countScorePlayer(Player player) {
        long score = 0;
        int listSize = player.getCards().size();
        for (int i = 0; i < player.getCards().size(); i++) {
            score += (long) (listSize - i) * player.getCards().get(i);
        }
        return score;
    }
}
