package lt.justassub.adventofcode.year2020.day22;

import lt.justassub.adventofcode.year2020.Main2020;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day22 extends Main2020<List<Player>, List<Player>, Long, Long> {

    @Override
    protected Long part1(List<Player> input) {
        ScoreCalculator scoreCalculator = new ScoreCalculator(input);
        for (int i = 0; i < input.size() - 1; i += 2) {
            WarGame warGame = new WarGame(input.get(i), input.get(i + 1));//each plays with other
            warGame.playGame();
        }
        return scoreCalculator.calculateScores();
    }

    @Override
    protected Long part2(List<Player> input) {
        return null;
    }

    public static void main(String[] args) {
        Day22 day22 = new Day22();
        String commonInfo = day22.getFileContent().collect(Collectors.joining("\n"));

        List<Player> playerList = new ArrayList<>();

        String[] playersInfo = commonInfo.split("\n\n");
        for (String info : playersInfo) {
            String[] nameAndCards = info.split(":\n");
            Player player = new Player(nameAndCards[0]);
            List<Integer> cards = Stream.of(nameAndCards[1].split("\n"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            playerList.add(player);
            player.addCards(cards.toArray(Integer[]::new));
        }

        System.out.println(day22.part1(playerList));

    }
}
