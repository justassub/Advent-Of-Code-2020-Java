package lt.justassub.adventofcode.year2020.day19;

import lt.justassub.adventofcode.year2020.Main2020;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day19 extends Main2020<String, String, Long, Long> {
    @Override
    protected Long part1(String input) {
        String[] splitInput = input.split(
                "\n" +
                        "\n");
        List<String> messages = Stream.of(splitInput[1].split("\n")).collect(Collectors.toList());
        String validators = splitInput[0];
        Map<Long, MessageValidator> rules = Day19Util.fillRulesWithInformation(validators);
        MessageValidator validatorZero = rules.get(0L);

        long count = 0;
        for (String message : messages) {
            try {
                String answer = validatorZero.validate(message);
                if (validatorZero.validate(message) != null && answer.equals("")) {
                    count++;
                }

            } catch (NotValidException e) {
                throw new RuntimeException("Should not happen");
            }
        }
        return count;
    }

    @Override
    protected Long part2(String input) {
        return null;
    }

    public static void main(String[] args) {
        Day19 day19 = new Day19();
        String content = day19.getFileContent().collect(Collectors.joining("\n"));
        System.out.println(day19.part1(content));
    }
}
