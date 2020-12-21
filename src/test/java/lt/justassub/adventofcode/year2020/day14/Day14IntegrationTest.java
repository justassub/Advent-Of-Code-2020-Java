package lt.justassub.adventofcode.year2020.day14;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class Day14IntegrationTest {
    private final Day14 day14 = new Day14();

    @Test
    public void testPart1() {
        List<String> input = List.of(
                "mask = XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X",
                "mem[8] = 11",
                "mem[7] = 101",
                "mem[8] = 0"
        );
        Assert.assertEquals(165,day14.part1(input).intValue());

    }
    @Test
    public void testPart2() {
        List<String> input = List.of(
                "mask = 000000000000000000000000000000X1001X",
                "mem[42] = 100",
                "mask = 00000000000000000000000000000000X0XX",
                "mem[26] = 1"
        );
        Assert.assertEquals(208,day14.part2(input).longValue());

    }
}
