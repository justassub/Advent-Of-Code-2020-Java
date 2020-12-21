package lt.justassub.adventofcode.year2020.day14;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class Day14Util {
    public static boolean checkIfMask(String string) {
        return string.startsWith("mask = ");
    }

    public static String extractMask(String line) {
        return line.replace("mask = ", "");
    }

    public static long calculateDecimalValueByBinaryStringWithNulls(String customBinaryString) {
        return Long.parseLong(customBinaryString, 2);
    }

    public static String generateBinaryValue(long decimalValue) {
        int maxSize = 36;
        String binary = Long.toBinaryString(decimalValue);
        String leftOvers = Stream.generate(() -> "0")
                .limit(maxSize - binary.length())
                .collect(joining());
        return leftOvers + binary;
    }

    public static String calculateBinaryStringIntersectionWithMask(String binaryString, String mask) {
        StringBuilder stringBuilder = new StringBuilder(binaryString);
        for (int i = 0; i < binaryString.length(); i++) {
            char currentMaskLetter = mask.charAt(i);
            if (currentMaskLetter == 'X') {
                //Do nothing
            } else {
                if (currentMaskLetter == '1' || currentMaskLetter == '0') {
                    stringBuilder.setCharAt(i, currentMaskLetter);
                } else {
                    throw new RuntimeException("Bad letter");
                }
            }
        }
        return stringBuilder.toString();
    }

    public static String calculateBinaryStringIntersectionWithMaskPart2(String binaryString, String mask) {
        StringBuilder stringBuilder = new StringBuilder(binaryString);
        for (int i = 0; i < binaryString.length(); i++) {
            char currentMaskLetter = mask.charAt(i);
            if (currentMaskLetter == 'X' || currentMaskLetter == '1') {
                stringBuilder.setCharAt(i, currentMaskLetter);
            } else if (currentMaskLetter == '0') {
                //do nothing
            } else {
                throw new RuntimeException("Bad letter");
            }
        }
        return stringBuilder.toString();
    }

    public static List<String> generateAllPossibleValues(String binaryString) {
        List<String> values = new ArrayList<>();
        int firstIndex = binaryString.indexOf('X');
        if (firstIndex < 0) {
            values.add(binaryString);
            return values;
        }

        String changeWithZero = binaryString.substring(0, firstIndex) + '0' + binaryString.substring(firstIndex + 1);
        String changeWithOne = binaryString.substring(0, firstIndex) + '1' + binaryString.substring(firstIndex + 1);

        values.addAll(generateAllPossibleValues(changeWithZero));
        values.addAll(generateAllPossibleValues(changeWithOne));

        return values;

    }

    public static Map.Entry<Integer, Integer> extractMemoryLocationAndValueFrom(String line) {
        ///TODO ask nerijus how to do??
        //mem[8] = 11
        // String to be scanned to find the pattern.
        String pattern = "mem\\[(\\d+)\\] = (\\d+)";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(line);
        if (m.find()) {
            String index = m.group(1);
            String value = m.group(2);
            return Map.entry(Integer.parseInt(index), Integer.parseInt(value));
        }


        throw new RuntimeException();
    }

}
