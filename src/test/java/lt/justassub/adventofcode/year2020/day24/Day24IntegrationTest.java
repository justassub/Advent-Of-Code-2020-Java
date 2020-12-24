package lt.justassub.adventofcode.year2020.day24;

import lt.justassub.adventofcode.year2020.util.TestDataUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class Day24IntegrationTest {
    Day24 day24 = new Day24();
    List<String> testData = TestDataUtil.getFileContent("day24").collect(Collectors.toList());

    @Test
    public void part1Example1() {
        Assert.assertEquals(10, day24.part1(testData).intValue());
    }

    @Test
    public void part2Example1() {
        Assert.assertEquals(2208, day24.part2(testData).intValue());
    }
}
