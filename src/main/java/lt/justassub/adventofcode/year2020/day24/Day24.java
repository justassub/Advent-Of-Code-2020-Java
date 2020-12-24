package lt.justassub.adventofcode.year2020.day24;

import lt.justassub.adventofcode.year2020.Main2020;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Day24 extends Main2020<List<String>, List<String>, Long, Long> {
    @Override
    protected Long part1(List<String> input) {

        return input.stream()
                .map(LayoutFactory::buildLayout)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values().stream()
                .filter(n -> n % 2 != 0)
                .count();
    }

    @Override
    protected Long part2(List<String> input) {
        return null;
    }

    public static void main(String[] args) {
        Day24 day24 = new Day24();
        List<String> content = day24.getFileContent().collect(Collectors.toList());
        System.out.println(day24.part1(content));
    }
}
