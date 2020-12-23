package lt.justassub.adventofcode.year2020.day23;

import org.junit.Assert;
import org.junit.Test;

public class IntegrationTest {
    Day23 day23 = new Day23();


    @Test
    public void part1Example1() {
        String sample = "389125467";
        String result = day23.part1(sample);
        Assert.assertEquals("67384529",result);
    }
}
