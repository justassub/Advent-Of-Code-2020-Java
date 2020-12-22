package lt.justassub.adventofcode.year2020.day22;

import lt.justassub.adventofcode.year2020.Main2020;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day22 extends Main2020<List<Player>, List<Player>, Long, Long> {

    @Override
    protected Long part1(List<Player> input) {
        return playGameAndCalculateScore(input, (p1, p2) -> new WarGame(p1, p2).playGame());
    }

    @Override
    protected Long part2(List<Player> input) {
        return playGameAndCalculateScore(input, (p1, p2) -> new RecursiveWarGame(p1, p2).playRecursive());
    }

    private long playGameAndCalculateScore(List<Player> playerList, BiFunction<Player, Player, Player> function) {
        List<Player> winners = new ArrayList<>();
        for (int i = 0; i < playerList.size() - 1; i += 2) {

            winners.add(function.apply(playerList.get(i), playerList.get(i + 1)));
        }
        return new ScoreCalculator(winners).calculateScores();
    }

    public static void main(String[] args) {
        Day22 day22 = new Day22();
        String commonInfo = day22.getFileContent().collect(Collectors.joining("\n"));

        System.out.println(day22.part1(createPlayers(commonInfo)));
        System.out.println(day22.part2(createPlayers(commonInfo)));

    }

    private static List<Player> createPlayers(String commonInfo) {
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
        return playerList;
    }
}
