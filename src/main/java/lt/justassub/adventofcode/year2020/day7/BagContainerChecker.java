package lt.justassub.adventofcode.year2020.day7;

import lt.justassub.adventofcode.year2020.day7.domain.Bag;

import java.util.List;
import java.util.Optional;

public class BagContainerChecker {
    public static boolean canBagContain(Bag parent, String hasToContain, List<Bag> allBags) {
        boolean canContain;

        canContain = parent.canContainThisColour(hasToContain);
        if (canContain) {
            return true;
        }

        canContain = parent.getOtherBags().stream()
                .anyMatch(c -> checkResurcive(c.getKey(), allBags, hasToContain)); // wavy magenta
        return canContain;
    }

    public static boolean checkResurcive(String colour, List<Bag> allBags, String hasToContain) {

        Optional<Bag> optBag = allBags.stream()
                .filter(b -> b.getColour().equals(colour))
                .findFirst();
        if (optBag.isEmpty()) {
            return false;
        }

        Bag bag = optBag.get();
        if (bag.canContainThisColour(hasToContain)) {
            return true;
        }

        return bag.getOtherBags().stream()
                .anyMatch(b -> checkResurcive(b.getKey(), allBags, hasToContain));
    }

    public static int bagsCounter(List<Bag> allBags, String colour) {
        Optional<Bag> optBag = allBags.stream()
                .filter(b -> b.getColour().equals(colour))
                .findFirst();

        if (optBag.isEmpty()) {
            return 1;
        }

        Bag bag = optBag.get();

        return bag.getOtherBags().stream()
                .map(values -> values.getValue() * bagsCounter(allBags, values.getKey()))
                .reduce(1, Integer::sum);
    }
}
