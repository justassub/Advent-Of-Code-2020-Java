package lt.justassub.adventofcode.year2020.day16;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class RuleTest {
    @Test
    public void validateValidSingleValidRange() {
        Rule rule = new Rule("class", Map.of(1, 3));
        Assert.assertTrue(rule.validateNearbyTicket(1));
        Assert.assertTrue(rule.validateNearbyTicket(2));
        Assert.assertTrue(rule.validateNearbyTicket(3));
    }

    @Test
    public void validateValidDoubleValidRange() {
        Rule rule = new Rule("class", Map.of(1, 3, 5, 7));
        Assert.assertTrue(rule.validateNearbyTicket(2));
        Assert.assertTrue(rule.validateNearbyTicket(6));
        Assert.assertTrue(rule.validateNearbyTicket(3));
    }
    @Test
    public void validateNotValidSingleValidRange() {
        Rule rule = new Rule("class", Map.of(1, 3));
        Assert.assertFalse(rule.validateNearbyTicket(4));
        Assert.assertFalse(rule.validateNearbyTicket(0));
        Assert.assertFalse(rule.validateNearbyTicket(7));
    }
    @Test
    public void validateNotValidDoubleValidRange() {
        Rule rule = new Rule("class", Map.of(1, 3, 5, 7));
        Assert.assertFalse(rule.validateNearbyTicket(0));
        Assert.assertFalse(rule.validateNearbyTicket(8));
        Assert.assertFalse(rule.validateNearbyTicket(4));
    }
}
