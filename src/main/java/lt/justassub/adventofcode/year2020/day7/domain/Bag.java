package lt.justassub.adventofcode.year2020.day7.domain;

import java.util.List;
import java.util.Map;

public class Bag {
    private String colour;
    private List<Map.Entry<String, Integer>> otherBags;

    public Bag(String colour, List<Map.Entry<String, Integer>> canContainBags) {
        this.colour = colour;
        this.otherBags = canContainBags;
    }

    public String getColour() {
        return colour;
    }

    public List<Map.Entry<String, Integer>> getOtherBags() {
        return otherBags;
    }

    public boolean canContainThisColour(String colour) {
        return otherBags.stream()
                .anyMatch(v -> v.getKey().equals(colour));
    }
}
