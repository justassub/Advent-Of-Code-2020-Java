package lt.justassub.adventofcode.year2020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Day15 extends Main2020<String, String, Long, Long> {


    @Override
    protected Long part1(String input) {
        int maxNumbers = 2020;

        List<Integer> startingNumbers = Stream.of(input.split(",")).map(Integer::parseInt).collect(toList());
        List<Integer> history = generateHistoryGame(startingNumbers, maxNumbers);
        return history.get(history.size() - 1).longValue();
    }

    @Override
    protected Long part2(String input) {
        int maxNumbers = 30000000;

        List<Integer> startingNumbers = Stream.of(input.split(",")).map(Integer::parseInt).collect(toList());
        List<Integer> history = generateHistoryGame(startingNumbers, maxNumbers);
        return history.get(history.size() - 1).longValue();
    }

    public List<Integer> generateHistoryGame(List<Integer> startingNumbers, int maximumSize) {
        Map<Integer, Integer> history = new HashMap<>();
        List<Integer> numbers = new ArrayList<>();
        int lastNumber = 0;

        for (int i = 0; i < maximumSize; i++) {
            int num;
            if (i < startingNumbers.size()) {
                num = startingNumbers.get(i);
            } else {
                if (!history.containsKey(lastNumber)) {
                    num = 0;
                } else {
                    num = i - 1 - history.get(lastNumber);
                }
            }
            history.put(lastNumber, i - 1);
            lastNumber = num;
            numbers.add(lastNumber);
        }

        return numbers;
    }


    public static void main(String[] args) {
        Day15 day15 = new Day15();
        System.out.println(day15.part1("7,14,0,17,11,1,2"));
        System.out.println(day15.part2("7,14,0,17,11,1,2"));

    }
}
