package lt.justassub.adventofcode.year2020.day19;

import org.junit.Assert;
import org.junit.Test;

public class Day19IntegrationTest {
    @Test
    public void part1Example1() {
        Day19 day19 = new Day19();
        String content = """
                0: 4 1 5
                1: 2 3 | 3 2
                2: 4 4 | 5 5
                3: 4 5 | 5 4
                4: "a"
                5: "b"
                                
                ababbb
                bababa
                abbbab
                aaabbb
                aaaabbb
                """;
        Assert.assertEquals(2L, day19.part1(content).longValue());
    }
}
