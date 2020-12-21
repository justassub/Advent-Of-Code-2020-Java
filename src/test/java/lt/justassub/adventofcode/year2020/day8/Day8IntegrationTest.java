package lt.justassub.adventofcode.year2020.day8;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;

public class Day8IntegrationTest {

    @Test
    public void Day8ITTest() {
        List<String> inputLines = asList(
                "nop +0",
                "acc +1",
                "jmp +4",
                "acc +3",
                "jmp -3",
                "acc -99",
                "acc +1",
                "jmp -4",
                "acc +6"
        );
        Day8 day8 = new Day8();
        Assert.assertEquals(5, day8.part1(inputLines).intValue());
        Assert.assertEquals(8, day8.part2(inputLines).intValue());
    }
}
