package lt.justassub.adventofcode.year2020.day7;

import lt.justassub.adventofcode.year2020.day7.domain.BagParserExeception;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class BagsParser {
    private static final String NO_BAGS_CONTAIN_STRING = " bags contain no other bags.";
    private static final String BAGS_VALUES_ENDING = " bags.";
    private static final String BAGS_SEPARATOR = " bags, ";
    private static final String BAG_SEPARATOR = " bag, ";

    private static final String NAME_VALUES_SEPARATOR = " bags contain ";
    private static final String SINGLE_BAG_VALUE_ENDING = " bag.";

    public static Map.Entry<String, List<Map.Entry<String, Integer>>> parseLinetoValues(String line) {
        if (line == null) {
            throw new BagParserExeception();
        }
        if (line.contains(NO_BAGS_CONTAIN_STRING)) {
            return Map.entry(line.replace(NO_BAGS_CONTAIN_STRING, ""), Collections.emptyList());
        }

        String[] splitedValues = line.split(NAME_VALUES_SEPARATOR);

        String bagName = splitedValues[0];

        String values = splitedValues[1].replace(BAGS_VALUES_ENDING, "").replace(SINGLE_BAG_VALUE_ENDING, "");
        if (values.contains(BAGS_SEPARATOR)) {
           values= values.replace(BAGS_SEPARATOR, BAG_SEPARATOR);
        }
        List<Map.Entry<String, Integer>> valuesCanContain = Stream.of(values.split(BAG_SEPARATOR))
                .map(BagsParser::splitHowMuchCanContain)
                .collect(toList());

        return Map.entry(bagName, valuesCanContain);
    }

    private static Map.Entry<String, Integer> splitHowMuchCanContain(String value) {
        int firstIndexOfSpace = value.indexOf(" ");
        int howMuch = Integer.parseInt(value.substring(0, firstIndexOfSpace));
        String colour = value.substring(firstIndexOfSpace + 1);
        return Map.entry(colour, howMuch);
    }
}
