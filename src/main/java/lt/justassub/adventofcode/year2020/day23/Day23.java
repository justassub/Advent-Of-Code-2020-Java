package lt.justassub.adventofcode.year2020.day23;

import lt.justassub.adventofcode.year2020.Main2020;

import java.util.LinkedList;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toCollection;

public class Day23 extends Main2020<String, String, String, String> {
    @Override
    protected String part1(String input) {
        LinkedList<Integer> innitialNumbers = Stream.of(input.split(""))
                .map(Integer::valueOf)
                .collect(toCollection(LinkedList::new));
        CupGame cupGame = new CupGame(100, innitialNumbers);
        innitialNumbers = cupGame.playGame();
        int indexOfOne = innitialNumbers.indexOf(1);


        return Stream.concat(
                innitialNumbers.subList(indexOfOne + 1, innitialNumbers.size()).stream(),
                innitialNumbers.subList(0, indexOfOne).stream()
        )
                .map(Object::toString)
                .collect(joining());
    }

    @Override
    protected String part2(String input) {
        return null;
    }

    public static void main(String[] args) {
        Day23 day23 = new Day23();
        System.out.println(day23.part1("962713854"));
    }
}
