package lt.justassub.adventofcode.year2020.day7;

import lt.justassub.adventofcode.year2020.day7.domain.Bag;
import org.junit.Test;

import java.util.Collections;
import java.util.Map;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BagTest {
    @Test
    public void bagDoesNotContainTest() {
        Bag bag = new Bag("test", Collections.emptyList());
        assertFalse(bag.canContainThisColour("Gold"));
    }

    @Test
    public void bagDoesContainTest() {
        Bag bag = new Bag("test", singletonList(Map.entry("Test", 1)));
        assertTrue(bag.canContainThisColour("Test"));
    }

    @Test
    public void bagDoesContainTest2() {
        Bag bag = new Bag("test", asList(Map.entry("Test", 1), Map.entry("Test2", 2)));
        assertTrue(bag.canContainThisColour("Test2"));
    }
}
