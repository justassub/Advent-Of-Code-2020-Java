package lt.justassub.adventofcode.year2020.day14;

import lt.justassub.adventofcode.year2020.Main2020;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;
import static lt.justassub.adventofcode.year2020.day14.Day14Util.checkIfMask;
import static lt.justassub.adventofcode.year2020.day14.Day14Util.extractMask;


public class Day14 extends Main2020<List<String>, List<String>, Long, Long> {
    @Override
    protected Long part1(List<String> input) {
        String mask = null;
        Map<Integer, MemoryBlock> history = new HashMap<>();
        for (String line : input) {
            if (checkIfMask(line)) {
                mask = extractMask(line);
                continue;
            }
            Map.Entry<Integer, Integer> lineInfo = Day14Util.extractMemoryLocationAndValueFrom(line);
            int index = lineInfo.getKey();
            int value = lineInfo.getValue();

            String valueBinaryCode = Day14Util.generateBinaryValue(value);
            String afterInteractionWithMask = Day14Util.calculateBinaryStringIntersectionWithMask(valueBinaryCode, mask);

            MemoryBlock memoryBlock = new MemoryBlock(index, Day14Util.calculateDecimalValueByBinaryStringWithNulls(afterInteractionWithMask));
            history.put(index, memoryBlock);

        }
        return history.values()
                .stream()
                .map(v -> Day14Util.calculateDecimalValueByBinaryStringWithNulls(v.getBinaryString()))
                .reduce(0L, Long::sum);
    }


    @Override
    protected Long part2(List<String> input) {
        String mask = null;
        Map<Long, Long> history = new HashMap<>();
        for (String line : input) {
            if (checkIfMask(line)) {
                mask = extractMask(line);
                continue;
            }
            Map.Entry<Integer, Integer> lineInfo = Day14Util.extractMemoryLocationAndValueFrom(line);
            int index = lineInfo.getKey();

            long value = lineInfo.getValue();

            String valueBinaryCode = Day14Util.generateBinaryValue(index);
            String afterInteractionWithMask = Day14Util.calculateBinaryStringIntersectionWithMaskPart2(valueBinaryCode, mask);

            List<String> possibleValues = Day14Util.generateAllPossibleValues(afterInteractionWithMask);
            for (String possibleValueBynary : possibleValues) {
                long possibleValueDecimal = Day14Util.calculateDecimalValueByBinaryStringWithNulls(possibleValueBynary);
                history.put(possibleValueDecimal, value);
            }

        }
        return history.values()
                .stream()
                .reduce(0L, Long::sum);
    }

    public static void main(String[] args) {
        Day14 day14 = new Day14();
        List<String> info = day14.getFileContent().collect(toList());
        System.out.println(day14.part1(info));
        System.out.println(day14.part2(info));
    }
}
