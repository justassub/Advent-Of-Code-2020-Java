package lt.justassub.adventofcode.year2020.day19;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class Day19UtilTest {
    @Test
    public void simpleStringParser() {
        String text = """
                0: 4 1 5
                1: 2 3 | 3 2
                2: 4 4 | 5 5
                3: 4 5 | 5 4
                4: "a"
                5: "b"
                """;
        Map<Long, MessageValidator> messageValidators = Day19Util.fillRulesWithInformation(text);
        Assert.assertEquals(6,messageValidators.size());
    }
}
