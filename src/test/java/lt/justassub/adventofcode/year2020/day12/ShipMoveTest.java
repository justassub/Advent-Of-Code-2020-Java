package lt.justassub.adventofcode.year2020.day12;

import org.junit.Assert;
import org.junit.Test;

public class ShipMoveTest {

    @Test
    public void noMovementTest() {
        Ship ship = new Ship();
        Assert.assertEquals(0, ship.getX());
        Assert.assertEquals(0, ship.getY());
    }

    @Test
    public void nmoveForwardOnlyTest() {
        Ship ship = new Ship();
        ship.moveForward(10);
        Assert.assertEquals(10, ship.getX());
        Assert.assertEquals(0, ship.getY());
    }

    @Test
    public void example1() {
        Ship ship = new Ship();
        ship.moveForward(10);
        ship.moveToDirection(Directory.N, 3);
        Assert.assertEquals(10, ship.getX());
        Assert.assertEquals(3, ship.getY());
    }

    @Test
    public void example2() {
        Ship ship = new Ship();
        ship.moveForward(10);
        ship.moveToDirection(Directory.N, 3);
        ship.moveForward(7);

        Assert.assertEquals(17, ship.getX());
        Assert.assertEquals(3, ship.getY());
    }

    @Test
    public void example3() {
        Ship ship = new Ship();
        ship.moveForward(10);
        ship.moveToDirection(Directory.N, 3);
        ship.moveForward(7);
        ship.changeFacingDirectoryByDegrees(90);
        ship.moveForward(11);

        Assert.assertEquals(17, ship.getX());
        Assert.assertEquals(-8, ship.getY());
    }
}
