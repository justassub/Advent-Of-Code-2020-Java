package lt.justassub.adventofcode.year2020;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Day3 extends Main2020<List<String>, List<String>, Long, Long> {
    @Override
    protected Long part1(List<String> input) {
        List<List<Boolean>> booleanMap = parseLineToTrees(input);
        return calculateTrees(booleanMap, 1, 3);
    }

    @Override
    protected Long part2(List<String> input) {
        List<List<Boolean>> booleanMap = parseLineToTrees(input);
        long trees1 = calculateTrees(booleanMap, 1, 1);
        long trees2 = calculateTrees(booleanMap, 1, 3);
        long trees3 = calculateTrees(booleanMap, 1, 5);
        long trees4 = calculateTrees(booleanMap, 1, 7);
        long trees5 = calculateTrees(booleanMap, 2, 1);
        return trees1 * trees2 * trees3 * trees4 * trees5;
    }


    private Long calculateTrees(List<List<Boolean>> trees, int lineIncrement, int charIncrement) {
        long countTrees = 0;
        int lineThisMoment = 0;
        int positionThisMoment = 0;
        int lineCount = trees.size();
        int lineSize = trees.get(0).size();
        while (lineThisMoment < lineCount) {
            if (hadTree(trees, lineThisMoment, positionThisMoment)) {
                countTrees++;
            }
            lineThisMoment += lineIncrement;
            positionThisMoment += charIncrement;
            if (lineSize <= positionThisMoment) {
                positionThisMoment -= lineSize;
            }
        }
        return countTrees;
    }

    private boolean hadTree(List<List<Boolean>> isTreeInformation, int lineAtThisMoment, int positionAtThisTime) {
        return isTreeInformation.get(lineAtThisMoment).get(positionAtThisTime);
    }

    private List<List<Boolean>> parseLineToTrees(List<String> input) {
        return input.stream()
                .map(this::parseLine)
                .collect(toList());

    }

    private List<Boolean> parseLine(String infoAboutLine) {
        return Stream.of(infoAboutLine.split(""))
                .map(l -> l.equals("#"))
                .collect(toList());
    }

    public static void main(String[] args) {
        Day3 day3 = new Day3();
        List<String> data = day3.getFileContent().collect(toList());
        System.out.println(day3.part1(data));
        System.out.println(day3.part2(data));
    }
}

