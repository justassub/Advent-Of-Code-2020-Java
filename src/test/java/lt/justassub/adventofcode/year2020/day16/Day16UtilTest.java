package lt.justassub.adventofcode.year2020.day16;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class Day16UtilTest {

    @Test
    public void parseValidationRule1() {
        String line = "class: 1-3 or 5-7";
        Rule rule = Day16Util.parseLineToRule(line);
        Assert.assertEquals("class", rule.getName());
        Assert.assertEquals(2, rule.getAllowedValues().size());
        Assert.assertTrue(rule.getAllowedValues().containsKey(1));
        Assert.assertTrue(rule.getAllowedValues().containsKey(1));
        Assert.assertTrue(rule.getAllowedValues().containsKey(5));

        Assert.assertEquals(3, rule.getAllowedValues().get(1).intValue());
        Assert.assertEquals(7, rule.getAllowedValues().get(5).intValue());

    }

    @Test
    public void mergeRuleCorrectly() {
        String line = "departure: 1-3 or 1-7";
        Rule rule = Day16Util.parseLineToRule(line);
        Assert.assertEquals("departure", rule.getName());
        Assert.assertEquals(1, rule.getAllowedValues().size());
        Assert.assertTrue(rule.getAllowedValues().containsKey(1));
        Assert.assertEquals(7, rule.getAllowedValues().get(1).intValue());
    }

    @Test
    public void mergeRulesCorrectly() {
        String text = "class: 1-3 or 5-7\n" +
                "row: 6-11 or 33-44\n" +
                "seat: 13-40 or 45-50";

        List<Rule> rules = Day16Util.parseStringToRules(text);
        Assert.assertEquals(3, rules.size());
    }
}
