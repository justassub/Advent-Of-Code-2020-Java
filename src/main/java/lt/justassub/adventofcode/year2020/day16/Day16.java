package lt.justassub.adventofcode.year2020.day16;

import lt.justassub.adventofcode.year2020.Main2020;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public class Day16 extends Main2020<String, String, Long, Long> {
    @Override
    protected Long part1(String input) {
        String[] splitedInfo = input.split("\n" +
                "your ticket:\n");
        String rules = splitedInfo[0];

        String nearbyTicketsString = splitedInfo[1].split("nearby tickets:\n")[1];

        List<Rule> ruleList = Day16Util.parseStringToRules(rules);
        List<Integer> integersAsGroup = Stream.of(nearbyTicketsString.split("\n"))
                .flatMap(line -> Stream.of(line.split(",")).map(Integer::parseInt))
                .collect(toList());
        List<Long> validTickets = getValidTickets(ruleList, integersAsGroup);
        return validTickets.stream()
                .reduce(0L, Long::sum);
    }

    @Override
    protected Long part2(String input) {
        String[] splitedInfo = input.split("\n" +
                "your ticket:\n");
        String rules = splitedInfo[0];

        String[] otherInfo = splitedInfo[1].split("nearby tickets:\n");
        String myTicketsString = otherInfo[0].replace("\n", "");
        List<Long> myTickets = Stream.of(myTicketsString.split(","))
                .map(Long::parseLong)
                .collect(toList());

        String nearbyTicketsString = otherInfo[1];
        List<List<Integer>> integersAsGroup = Stream.of(nearbyTicketsString.split("\n"))
                .map(line -> Stream.of(line.split(",")).map(Integer::parseInt).collect(toList()))
                .collect(toList());

        List<Rule> ruleList = Day16Util.parseStringToRules(rules);

        Map<Integer, List<Integer>> validGroupsWithIndexes = integersAsGroup.stream()
                .filter(g -> Day16Util.checkIfAllNumbersAreCorect(ruleList, g))
                .map(Day16Util::groupNumbersbyIndex)
                .flatMap(s -> s.entrySet().stream())
                .collect(toMap(Map.Entry::getKey, a -> List.of(a.getValue()), (a, b) -> Stream.concat(a.stream(), b.stream()).collect(Collectors.toList())));

        Map<Integer, Set<Rule>> indexesWithPossibleRules = new HashMap<>();
        for (Map.Entry<Integer, List<Integer>> values : validGroupsWithIndexes.entrySet()) {
            indexesWithPossibleRules.put(values.getKey(), new HashSet<>());
            for (Rule r : ruleList) {

                boolean allNumbersPass = values.getValue().stream()
                        .allMatch(r::validateNearbyTicket);
                if (allNumbersPass) {
                    indexesWithPossibleRules.get(values.getKey()).add(r);
                }
            }


        }
        Map<Rule, Integer> rulesWithIndex = indexRules(new HashMap<>(), indexesWithPossibleRules);

        return rulesWithIndex.entrySet().stream()
                .filter(v -> v.getKey().getName().startsWith("departure"))
                .map(Map.Entry::getValue)
                .map(myTickets::get)
                .reduce(1L, (a, b) -> a * b);
    }

    public static Map<Rule, Integer> indexRules(Map<Rule, Integer> history, Map<Integer, Set<Rule>> indexesWithPossibleRules) {

        for (Map.Entry<Integer, Set<Rule>> values : indexesWithPossibleRules.entrySet()) {

            Set<Rule> possibleRules = values.getValue().stream()
                    .filter(v -> !history.containsKey(v))
                    .collect(Collectors.toSet());

            if (possibleRules.size() == 1) {
                possibleRules.forEach(r -> history.put(r, values.getKey()));
            }
        }
        if (history.size() == indexesWithPossibleRules.size()) {
            return history;
        } else {
            return indexRules(history, indexesWithPossibleRules);
        }
    }


    private static List<Long> getValidTickets(List<Rule> rules, List<Integer> integers) {
        Predicate<Integer> passedNoRules = n -> rules.stream().noneMatch(r -> r.validateNearbyTicket(n));
        return integers.stream()
                .filter(passedNoRules)
                .map(Long::valueOf)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Day16 day16 = new Day16();
        String text = day16.getFileContent().collect(Collectors.joining("\n"));
        System.out.println(day16.part1(text));
        System.out.println(day16.part2(text));

    }
}
