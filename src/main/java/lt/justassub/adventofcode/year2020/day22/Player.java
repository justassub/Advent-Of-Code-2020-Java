package lt.justassub.adventofcode.year2020.day22;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Arrays;
import java.util.LinkedList;

import static java.util.Arrays.asList;

@RequiredArgsConstructor
@Getter
@AllArgsConstructor
public class Player {
    private final String name;
    @Setter
    private LinkedList<Integer> cards = new LinkedList<>();

    public void addCards(Integer... cardsToAdd) {
        cards.addAll(asList(cardsToAdd));
    }
}
