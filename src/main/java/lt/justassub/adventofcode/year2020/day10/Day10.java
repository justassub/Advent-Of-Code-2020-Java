package lt.justassub.adventofcode.year2020.day10;

import lt.justassub.adventofcode.year2020.Main2020;
import java.util.*;

import static java.util.stream.Collectors.*;

public class Day10 extends Main2020<List<Integer>, List<Integer>, Long, Long> {

    @Override
    protected Long part1(List<Integer> input) {
        input.add(0, 0);
        Collections.sort(input);
        int builtInJoltageAdapter = input.get(input.size() - 1) + 3;
        input.add(builtInJoltageAdapter);
        List<Jolt> jolts = parseToJolts(input);
        Map<Integer, Long> counts = jolts.stream()
                .collect(groupingBy(Jolt::getDifference, counting()));
        return counts.get(1) * counts.get(3);
    }


    private List<Jolt> parseToJolts(List<Integer> sortedList) {
        List<Jolt> jolts = new ArrayList<>();

        for (int i = 1; i < sortedList.size(); i++) {
            Jolt jolt = new Jolt();
            int difference = sortedList.get(i) - sortedList.get(i - 1);
            difference = Math.min(difference, 3);
            jolt.setDifference(difference);
            jolt.setValue(sortedList.get(i));
            jolts.add(jolt);
        }
        return jolts;
    }

    @Override
    protected Long part2(List<Integer> input) {
        input.add(0, 0);
        Collections.sort(input);
        int builtInJoltageAdapter = input.get(input.size() - 1) + 3;
        input.add(builtInJoltageAdapter);

        return numWays(input);
    }

    public long numWays(List<Integer> input) {
        HashMap<Integer, Long> history = new HashMap<>();
        history.put(input.get(input.size() - 1) + 3, 1L);
        for (int i = input.size() - 1; i >= 0; i--) {
            int currentValue = input.get(i);
            history.put(currentValue, findAllPossibleCombsWithThisValue(history, currentValue));
        }

        return history.get(0);
    }

    private long findAllPossibleCombsWithThisValue(HashMap<Integer, Long> history, int currentValue) {
        return history.getOrDefault(currentValue + 1, 0L) +
                history.getOrDefault(currentValue + 2, 0L) +
                history.getOrDefault(currentValue + 3, 0L);

    }


    public static void main(String[] args) {
        Day10 main = new Day10();
        List<Integer> integers = main.getFileContent().map(Integer::parseInt).collect(toList());
        System.out.println(main.part1(new ArrayList<>(integers)));
        System.out.println(main.part2(new ArrayList<>(integers)));
    }
}
