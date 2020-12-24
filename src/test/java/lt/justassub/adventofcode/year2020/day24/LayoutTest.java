package lt.justassub.adventofcode.year2020.day24;

import org.junit.Assert;
import org.junit.Test;

public class LayoutTest {
    @Test
    public void simpleParser1() {
        Layout layout = LayoutFactory.buildLayout("esew");
        Assert.assertEquals(1, layout.getX());
        Assert.assertEquals(-1, layout.getY());
    }
    @Test
    public void simpleParser2() {
        Layout layout = LayoutFactory.buildLayout("nwwswee");
        Assert.assertEquals(0, layout.getX());
        Assert.assertEquals(0, layout.getY());
    }
}
