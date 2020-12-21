package lt.justassub.adventofcode.year2020.day18;

import lt.justassub.adventofcode.year2020.Main2020;

import java.util.List;
import java.util.stream.Collectors;

public class Day18 extends Main2020<List<String>, List<String>, Long, Long> {
    @Override
    protected Long part1(List<String> input) {
        return input.stream()
                .map(Day18Util::calculateLineWithParenthesesNoPriority)
                .reduce(0L, Long::sum);
    }

    @Override
    protected Long part2(List<String> input) {
        return input.stream()
                .map(line -> Day18Util.calculateLineWithParentheses(line, "+"))
                .reduce(0L, Long::sum);
    }

    public static void main(String[] args) {
        Day18 day18 = new Day18();
        List<String> lines = day18.getFileContent().collect(Collectors.toList());
        System.out.println(day18.part1(lines));
        System.out.println(day18.part2(lines));
    }
}
