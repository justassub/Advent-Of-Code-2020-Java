package lt.justassub.adventofcode.year2020;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Day1 extends Main2020<List<Integer>, List<Integer>, Integer, Integer> {
    @Override
    public Integer part1(List<Integer> integers) {
        for (int i = 0; i < integers.size() - 1; i++) {
            for (int k = i + 1; k < integers.size(); k++) {
                int firstNumber = integers.get(i);
                int secondNumber = integers.get(k);
                if (isSum2020(firstNumber, secondNumber)) {
                    return multiplyNumbers(firstNumber, secondNumber);
                }
            }
        }
        throw new RuntimeException("Numbers with sum 2020 not found");
    }

    @Override
    public Integer part2(List<Integer> integers) {
        for (int i = 0; i < integers.size() - 2; i++) {
            for (int k = i + 1; k < integers.size() - 1; k++) {
                for (int j = k + 1; j < integers.size(); j++) {
                    int firstNumber = integers.get(i);
                    int secondNumber = integers.get(k);
                    int thirdNumber = integers.get(j);
                    if (isSum2020(firstNumber, secondNumber, thirdNumber)) {
                        return multiplyNumbers(firstNumber, secondNumber, thirdNumber);
                    }
                }
            }
        }
        throw new RuntimeException("Numbers with sum 2020 not found");
    }

    private boolean isSum2020(Integer... numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum == 2020;
    }

    private int multiplyNumbers(Integer... numbers) {
        int answer = 1;
        for (int number : numbers) {
            answer *= number;
        }
        return answer;
    }

    public static void main(String[] args) {
        Day1 day01 = new Day1();
        List<Integer> integers = day01.getFileContent().map(Integer::parseInt).collect(toList());
        System.out.println(day01.part1(integers));
        System.out.println(day01.part2(integers));
    }
}
