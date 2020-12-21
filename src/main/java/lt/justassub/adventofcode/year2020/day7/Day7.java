package lt.justassub.adventofcode.year2020.day7;

import lt.justassub.adventofcode.year2020.Main2020;import lt.justassub.adventofcode.year2020.day7.domain.Bag;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Day7 extends Main2020<List<String>, List<String>, Integer, Integer> {
    private static final String SHINY_GOLD = "shiny gold";

    @Override
    public Integer part1(List<String> input) {
        int howManyCanContain = 0;
        List<Bag> bags = input.stream()
                .map(BagsParser::parseLinetoValues)
                .map(m -> new Bag(m.getKey(), m.getValue()))
                .collect(toList());


        for (Bag b : bags) {
            if (BagContainerChecker.canBagContain(b, SHINY_GOLD, bags)) {
                howManyCanContain++;
            }
        }
        return howManyCanContain;
    }

    @Override
    public Integer part2(List<String> input) {
        List<Bag> bags = input.stream()
                .map(BagsParser::parseLinetoValues)
                .map(m -> new Bag(m.getKey(), m.getValue()))
                .collect(toList());

        return BagContainerChecker.bagsCounter(bags,SHINY_GOLD)-1;
    }


    public static void main(String[] args) {
        Day7 day07 = new Day7();
        List<String> info = day07.getFileContent().collect(toList());
        System.out.println(day07.part1(info));
        System.out.println(day07.part2(info));
    }
}
