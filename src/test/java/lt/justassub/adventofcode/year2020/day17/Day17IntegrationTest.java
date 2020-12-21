package lt.justassub.adventofcode.year2020.day17;

import org.junit.Assert;
import org.junit.Test;

public class Day17IntegrationTest {
    Day17 day17 = new Day17();

    @Test
    public void testExample1() {
        String text = """
                .#.
                ..#
                ###
                """;
        Assert.assertEquals(112, day17.part1(text).intValue());
    }
    @Test
    public void  testExample2(){
        String text = """
                .#.
                ..#
                ###
                """;
        Assert.assertEquals(848, day17.part2(text).intValue());
    }
}
