package lt.justassub.adventofcode.year2020;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class Day15Test {
    Day15 day15 = new Day15();

    @Test
    public void shouldHaveOnlyGivenNumbers() {
        List<Integer> result = day15.generateHistoryGame(List.of(1, 2, 3), 3);
        Assert.assertEquals(3, result.size());
        Assert.assertEquals(1, result.get(0).intValue());
        Assert.assertEquals(2, result.get(1).intValue());
        Assert.assertEquals(3, result.get(2).intValue());
    }

    @Test
    public void shouldHaveExample1() {
        List<Integer> result = day15.generateHistoryGame(List.of(0, 3, 6), 2020);
        Assert.assertEquals(2020, result.size());
        Assert.assertEquals(0, result.get(0).intValue());
        Assert.assertEquals(3, result.get(1).intValue());
        Assert.assertEquals(6, result.get(2).intValue());
        Assert.assertEquals(0, result.get(3).intValue());
        Assert.assertEquals(3, result.get(4).intValue());
        Assert.assertEquals(3, result.get(5).intValue());
        Assert.assertEquals(1, result.get(6).intValue());
        Assert.assertEquals(0, result.get(7).intValue());
        Assert.assertEquals(4, result.get(8).intValue());
        Assert.assertEquals(0, result.get(9).intValue());
        Assert.assertEquals(436, result.get(2019).intValue());
    }
}
