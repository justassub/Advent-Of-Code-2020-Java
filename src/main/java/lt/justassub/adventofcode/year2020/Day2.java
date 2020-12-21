package lt.justassub.adventofcode.year2020;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Day2 extends Main2020<List<String>, List<String>, Long, Long> {
    @Override
    protected Long part1(List<String> input) {
        return input.stream()
                .filter(p -> passwordCheck(p, true))
                .count();
    }


    public static boolean passwordCheck(String passwordWithMeta, boolean isOldJob) {
        String[] splitLine = passwordWithMeta.split(": ");
        String password = splitLine[1];

        String meta = splitLine[0];
        String[] metaSplit = meta.split(" ");

        if (metaSplit[1].length() != 1) {
            throw new RuntimeException("Wrong meta info split: " + metaSplit[1]);
        }
        char c = metaSplit[1].charAt(0);

        String maxOccurrences = metaSplit[0];
        String[] minAndMaxNumbers = maxOccurrences.split("-");
        int minNumber = Integer.parseInt(minAndMaxNumbers[0]);
        int maxNumber = Integer.parseInt(minAndMaxNumbers[1]);
        if (isOldJob) {
            return matchesPasswordCountOldJob(c, minNumber, maxNumber, password);

        } else {
            return matchesPasswordCountNewJob(c, minNumber, maxNumber, password);

        }

    }

    private static boolean matchesPasswordCountOldJob(char letter, int lowestNumber, int maxNumber, String password) {
        int charCount = 0;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (c == letter) {
                charCount++;
            }
        }
        return charCount >= lowestNumber && charCount <= maxNumber;
    }

    private static boolean matchesPasswordCountNewJob(char letter, int firstPossition, int nextPosition, String password) {

        char atFirstPosition = password.charAt(firstPossition - 1);
        char atNextPosition = password.charAt(nextPosition - 1);


        return (atFirstPosition == letter || atNextPosition == letter) && (atFirstPosition != letter || atNextPosition != letter);
    }

    @Override
    protected Long part2(List<String> input) {
        return input.stream()
                .filter(p -> passwordCheck(p, false))
                .count();
    }

    public static void main(String[] args) {
        Day2 day02 = new Day2();
        List<String> integers = day02.getFileContent().collect(toList());
        System.out.println(day02.part1(integers));
        System.out.println(day02.part2(integers));
    }
}
