package lt.justassub.adventofcode.year2020.day16;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public class Day16Util {

    public static List<Rule> parseStringToRules(String text) {
        return Stream.of(text.split("\n"))
                .map(Day16Util::parseLineToRule)
                .collect(toList());
    }

    public static Rule parseLineToRule(String line) {
        String[] values = line.split(": ");
        String ruleName = values[0];
        Map<Integer, Integer> validations = Stream.of(values[1].split(" or "))
                .map(v -> v.split("-"))
                .map(v -> Map.entry(Integer.parseInt(v[0]), Integer.parseInt(v[1])))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, Math::max));
        return new Rule(ruleName, validations);

    }

    public static boolean checkIfAllNumbersAreCorect(List<Rule> rules, List<Integer> groups) {
        return groups.stream()
                .noneMatch(n -> rules.stream().noneMatch(rule -> rule.validateNearbyTicket(n)));

    }

    public static Map<Integer, Integer> groupNumbersbyIndex(List<Integer> group) {
        return IntStream.rangeClosed(0, group.size() - 1)
                .mapToObj(i -> Map.entry(i, group.get(i)))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
