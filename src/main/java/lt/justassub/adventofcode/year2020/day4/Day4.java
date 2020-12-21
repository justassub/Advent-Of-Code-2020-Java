package lt.justassub.adventofcode.year2020.day4;


import lt.justassub.adventofcode.year2020.Main2020;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Day4 extends Main2020<List<String>, List<String>, Long, Long> {
    @Override
    protected Long part1(List<String> input) {
        return Stream.of(String.join("\n", input)
                .split("\\n\\n"))
                .map(l -> String.join(" ", l.split("\n")))
                .map(PassportParser::parsePassportFields)
                .map(PassportFactory::createPassport)
                .filter(PassportValidator::isPasswordValidNoValueCheck)
                .count();

    }

    @Override
    protected Long part2(List<String> input) {

        return Stream.of(String.join("\n", input)
                .split("\\n\\n"))
                .map(l -> String.join(" ", l.split("\n")))
                .map(PassportParser::parsePassportFields)
                .map(PassportFactory::createPassport)
                .filter(PassportValidator::isPasswordValid)
                .count();
    }


    public static void main(String[] args) {
        Day4 day04 = new Day4();
        List<String> info = day04.getFileContent().collect(toList());
        System.out.println(day04.part1(info));
        System.out.println(day04.part2(info));
    }
}
