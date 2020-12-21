package lt.justassub.adventofcode.year2020.day12;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;

public class Day12Test {

    @Test
    public void example1() {
        List<String> example = asList(
                "F10",
                "N3",
                "F7",
                "R90",
                "F11"
        );
        Day12 day12 = new Day12();

        Assert.assertEquals(25, day12.part1(example).intValue());
    }
}
