package lt.justassub.adventofcode.year2020.day7;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class BagsParserTest {
    @Test
    public void expectEmptyValuesWithNoBags() {
        String testLine = "dotted black bags contain no other bags.";
        Map.Entry<String, List<Map.Entry<String,Integer>>> answer = BagsParser.parseLinetoValues(testLine);
        Assert.assertEquals("dotted black", answer.getKey());
        Assert.assertEquals(0, answer.getValue().size());
    }

    @Test
    public void expectGoodParsingSingleListOfValues() {
        String testLine = "bright white bags contain 1 shiny gold bag.";
        Map.Entry<String, List<Map.Entry<String,Integer>>> answer = BagsParser.parseLinetoValues(testLine);
        Assert.assertEquals("bright white", answer.getKey());
        Assert.assertEquals(1, answer.getValue().size());
        Assert.assertEquals(1, answer.getValue().get(0).getValue().intValue());
        Assert.assertEquals("shiny gold", answer.getValue().get(0).getKey());

    }
    @Test
    public void expectGoodParsingMultipleListOfValues() {
        String testLine = "dark olive bags contain 3 faded blue bags, 4 dotted black bags.";
        Map.Entry<String, List<Map.Entry<String,Integer>>> answer = BagsParser.parseLinetoValues(testLine);
        Assert.assertEquals("dark olive", answer.getKey());
        Assert.assertEquals(2, answer.getValue().size());
        Assert.assertEquals(3, answer.getValue().get(0).getValue().intValue());
        Assert.assertEquals("faded blue", answer.getValue().get(0).getKey());

        Assert.assertEquals(4, answer.getValue().get(1).getValue().intValue());
        Assert.assertEquals("dotted black", answer.getValue().get(1).getKey());
    }
    @Test
    public void expectGoodParsingSingleAndMultipleListOfValues() {
        String testLine = "shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.";
        Map.Entry<String, List<Map.Entry<String,Integer>>> answer = BagsParser.parseLinetoValues(testLine);
        Assert.assertEquals("shiny gold", answer.getKey());
        Assert.assertEquals(2, answer.getValue().size());

        Assert.assertEquals(1, answer.getValue().get(0).getValue().intValue());
        Assert.assertEquals("dark olive", answer.getValue().get(0).getKey());

        Assert.assertEquals(2, answer.getValue().get(1).getValue().intValue());
        Assert.assertEquals("vibrant plum", answer.getValue().get(1).getKey());
    }
    @Test
    public void expectGoodParsingSingleAndSingleListOfValues() {
        String testLine = "shiny gold bags contain 1 dark olive bag, 1 vibrant plum bag.";
        Map.Entry<String, List<Map.Entry<String,Integer>>> answer = BagsParser.parseLinetoValues(testLine);
        Assert.assertEquals("shiny gold", answer.getKey());
        Assert.assertEquals(2, answer.getValue().size());

        Assert.assertEquals(1, answer.getValue().get(0).getValue().intValue());
        Assert.assertEquals("dark olive", answer.getValue().get(0).getKey());

        Assert.assertEquals(1, answer.getValue().get(1).getValue().intValue());
        Assert.assertEquals("vibrant plum", answer.getValue().get(1).getKey());
    }
    @Test
    public void expectGoodParsingMultipleAndMultipleListOfValues() {
        String testLine = "shiny gold bags contain 881 dark olive bag, 188 vibrant plum bag.";
        Map.Entry<String, List<Map.Entry<String,Integer>>> answer = BagsParser.parseLinetoValues(testLine);
        Assert.assertEquals("shiny gold", answer.getKey());
        Assert.assertEquals(2, answer.getValue().size());

        Assert.assertEquals(881, answer.getValue().get(0).getValue().intValue());
        Assert.assertEquals("dark olive", answer.getValue().get(0).getKey());

        Assert.assertEquals(188, answer.getValue().get(1).getValue().intValue());
        Assert.assertEquals("vibrant plum", answer.getValue().get(1).getKey());
    }
    @Test
    public void productionError(){
        String testLine="light white bags contain 3 shiny gray bags, 1 bright gold bag, 1 light yellow bag.";
        Map.Entry<String, List<Map.Entry<String,Integer>>> answer = BagsParser.parseLinetoValues(testLine);
        Assert.assertEquals("light white", answer.getKey());
        Assert.assertEquals(3, answer.getValue().size());


    }
}
