package lt.justassub.adventofcode.year2020;

import java.util.List;
import java.util.Set;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class Day6 extends Main2020<List<String>, List<String>, Integer, Integer> {
    @Override
    public Integer part1(List<String> input) {
        return calculateGroupAnswersByMappingFunction(input, this::getGroupDistinctAnswers);
    }

    @Override
    public Integer part2(List<String> input) {
        return calculateGroupAnswersByMappingFunction(input, this::getGroupSameAnswers);

    }

    private int calculateGroupAnswersByMappingFunction(List<String> groupsAnswers, UnaryOperator<Set<String>> function) {
        return Stream.of(String.join("\n", groupsAnswers).split("\\n\\n"))
                .map(l -> Stream.of(l.split("\\n")).collect(toSet()))
                .map(function)
                .map(Set::size)
                .reduce(0, Integer::sum);
    }


    public Set<String> getGroupDistinctAnswers(Set<String> groupAnswers) {
        return groupAnswers.stream()
                .flatMap(s -> Stream.of(s.split("")))
                .collect(toSet());
    }

    public Set<String> getGroupSameAnswers(Set<String> answersList) {
        return answersList.stream()
                .flatMap(answer -> Stream.of(answer.split(""))
                        .filter(letter ->
                                answersList.stream()
                                        .allMatch(a -> a.contains(letter))
                        ))
                .collect(toSet());
    }
    public static void main(String[] args) {
        Day6 day06 = new Day6();
        List<String> info = day06.getFileContent().collect(toList());
        System.out.println(day06.part1(info));
        System.out.println(day06.part2(info));
    }

}
