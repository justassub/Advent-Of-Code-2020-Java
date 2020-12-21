package lt.justassub.adventofcode.year2020.day16;

import java.util.Map;

public class Rule {
    String name;
    Map<Integer, Integer> allowedValues;

    public Rule(String name, Map<Integer, Integer> allowedValues) {
        this.name = name;
        this.allowedValues = allowedValues;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Integer, Integer> getAllowedValues() {
        return allowedValues;
    }

    public void setAllowedValues(Map<Integer, Integer> allowedValues) {
        this.allowedValues = allowedValues;
    }

    /**
     * Validates if any other ticket is passing any rule
     *
     * @param number - number to validate
     */
    public boolean validateNearbyTicket(int number) {
        return allowedValues.entrySet()
                .stream()
                .anyMatch(v -> number >= v.getKey() && number <= v.getValue());
    }



}
