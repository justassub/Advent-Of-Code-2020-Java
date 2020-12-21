package lt.justassub.adventofcode.year2020.day5;

import org.junit.Assert;
import org.junit.Test;

public class TicketTest {
    @Test
    public void ticketShouldHaveColumnNotZero() {
        Ticket ticket = new Ticket("FBFBBFFRLR");
        Assert.assertNotEquals(0, ticket.getRow());
    }

    @Test
    public void ticketShouldHaveRowNotZero() {
        Ticket ticket = new Ticket("FBFBBFFRLR");
        Assert.assertNotEquals(0, ticket.getColumn());
    }
    @Test
    public void ticketShouldHaveSeatIdNotZero() {
        Ticket ticket = new Ticket("FBFBBFFRLR");
        Assert.assertNotEquals(0, ticket.getSeatId());
    }

    @Test
    public void ticketShouldHaveSample1() {
        Ticket ticket = new Ticket("FBFBBFFRLR");
        Assert.assertEquals(44, ticket.getRow());
        Assert.assertEquals(5, ticket.getColumn());
        Assert.assertEquals(357, ticket.getSeatId());
    }

    @Test
    public void ticketShouldHaveColumnSample2() {
        Ticket ticket = new Ticket("BFFFBBFRRR");
        Assert.assertEquals(70, ticket.getRow());
        Assert.assertEquals(7, ticket.getColumn());
        Assert.assertEquals(567, ticket.getSeatId());

    }

    @Test
    public void ticketShouldHaveColumnSample3() {
        Ticket ticket = new Ticket("FFFBBBFRRR");
        Assert.assertEquals(14, ticket.getRow());
        Assert.assertEquals(7, ticket.getColumn());
        Assert.assertEquals(119, ticket.getSeatId());

    }

    @Test
    public void ticketShouldHaveColumnSample4() {
        Ticket ticket = new Ticket("BBFFBBFRLL");
        Assert.assertEquals(102, ticket.getRow());
        Assert.assertEquals(4, ticket.getColumn());
        Assert.assertEquals(820, ticket.getSeatId());

    }
}
