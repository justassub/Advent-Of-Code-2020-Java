package lt.justassub.adventofcode.year2020.day14;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

public class Day14UtilTest {
    @Test
    public void checkIfItsMask() {
        String line = "mask = X101011X011X10101011000001X00XX0X000";
        Assert.assertTrue(Day14Util.checkIfMask(line));
    }

    @Test
    public void checkIfItsNotMask() {
        String line = "mem[60126] = 9674686";
        Assert.assertFalse(Day14Util.checkIfMask(line));
    }

    @Test
    public void extractMask() {
        String line = "mask = X101011X011X10101011000001X00XX0X000";
        String expectedLine = "X101011X011X10101011000001X00XX0X000";
        Assert.assertEquals(expectedLine, Day14Util.extractMask(line));
    }

    @Test
    public void calculateDecimalValueByBinaryStringWithNullsCorrectly() {
        String binary = "000000000000000000000000000001001001";
        Assert.assertEquals(73, Day14Util.calculateDecimalValueByBinaryStringWithNulls(binary));
    }

    @Test
    public void calculateDecimalValueByBinaryStringWithNullsCorrectly2() {
        String binary = "000000000000000000000000000001100101";
        Assert.assertEquals(101, Day14Util.calculateDecimalValueByBinaryStringWithNulls(binary));
    }

    @Test
    public void calculateBinaryStringIntercourseWithMask1() {
        String binary = "000000000000000000000000000000001011";
        String mask = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X";
        String expectedResult = "000000000000000000000000000001001001";
        Assert.assertEquals(expectedResult, Day14Util.calculateBinaryStringIntersectionWithMask(binary, mask));
    }

    @Test
    public void calculateBinaryStringIntercourseWithMask2() {
        String binary = "000000000000000000000000000000000000";
        String mask = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X";
        String expectedResult = "000000000000000000000000000001000000";
        Assert.assertEquals(expectedResult, Day14Util.calculateBinaryStringIntersectionWithMask(binary, mask));
    }

    @Test
    public void calculateBinaryStringIntercourseWithMask3() {
        String binary = "000000000000000000000000000001100101";
        String mask = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X";
        String expectedResult = "000000000000000000000000000001100101";
        Assert.assertEquals(expectedResult, Day14Util.calculateBinaryStringIntersectionWithMask(binary, mask));
    }

    @Test
    public void extractCorrectMemoryGroupAndValueFromString() {
        String line = "mem[8] = 11";
        Map.Entry<Integer, Integer> result = Day14Util.extractMemoryLocationAndValueFrom(line);
        Assert.assertEquals(8, result.getKey().intValue());
        Assert.assertEquals(11, result.getValue().intValue());
    }

    @Test
    public void extractCorrectMemoryGroupAndValueFromString2() {
        String line = "mem[88] = 1154";
        Map.Entry<Integer, Integer> result = Day14Util.extractMemoryLocationAndValueFrom(line);
        Assert.assertEquals(88, result.getKey().intValue());
        Assert.assertEquals(1154, result.getValue().intValue());
    }

    @Test
    public void calculateBinaryStringIntercourseWithMaskPart2Exmple1() {
        String binary = "000000000000000000000000000000101010";
        String mask = "000000000000000000000000000000X1001X";
        String expectedResult = "000000000000000000000000000000X1101X";
        Assert.assertEquals(expectedResult, Day14Util.calculateBinaryStringIntersectionWithMaskPart2(binary, mask));
    }

    @Test
    public void calculateBinaryStringIntercourseWithMaskPart2Example2() {
        String binary = "000000000000000000000000000000011010";
        String mask = "00000000000000000000000000000000X0XX";
        String expectedResult = "00000000000000000000000000000001X0XX";
        Assert.assertEquals(expectedResult, Day14Util.calculateBinaryStringIntersectionWithMaskPart2(binary, mask));
    }

    @Test
    public void generateAllPossibleValues() {
        String binary = "00000000000000000000000000000001X0XX";
        List<String> result = Day14Util.generateAllPossibleValues(binary);
        List<String> expectedResult = asList(
                "000000000000000000000000000000010000",
                "000000000000000000000000000000010001",
                "000000000000000000000000000000010010",
                "000000000000000000000000000000010011",
                "000000000000000000000000000000011000",
                "000000000000000000000000000000011001",
                "000000000000000000000000000000011010",
                "000000000000000000000000000000011011"
        );
        Assert.assertEquals(expectedResult.size(), result.size());
        Assert.assertArrayEquals(expectedResult.toArray(String[]::new), result.toArray(String[]::new));
    }
}
