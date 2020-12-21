package lt.justassub.adventofcode.year2020.day21;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Day21IntegrationTest {
    String input = """
            mxmxvkd kfcds sqjhc nhms (contains dairy, fish)
            trh fvjkl sbzzf mxmxvkd (contains dairy)
            sqjhc fvjkl (contains soy)
            sqjhc mxmxvkd sbzzf (contains fish)
            """;
    Day21 day21 = new Day21();
    List<String> lines = Stream.of(input.split("\n")).collect(toList());

    @Test
    public void part1IntegrationTest() {

       Assert.assertEquals(5L, day21.part1(lines).longValue());
    }
    @Test
    public void part2IntegrationTest() {

        Assert.assertEquals("mxmxvkd,sqjhc,fvjkl", day21.part2(lines));
    }
}
