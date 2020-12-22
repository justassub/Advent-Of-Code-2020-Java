package lt.justassub.adventofcode.year2020.day22;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.LinkedList;

import static java.util.Arrays.asList;

@RequiredArgsConstructor
@Getter
public class Player {
    private final String name;
    private LinkedList<Integer> cards = new LinkedList<>();

    public void addCards(Integer... cardsToAdd) {
        cards.addAll(asList(cardsToAdd));
    }
}
