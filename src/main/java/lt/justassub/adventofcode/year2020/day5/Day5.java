package lt.justassub.adventofcode.year2020.day5;

import lt.justassub.adventofcode.year2020.Main2020;
import java.util.List;
import java.util.TreeSet;

import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;

public class Day5 extends Main2020<List<Ticket>, List<Ticket>, Integer, Integer> {
    @Override
    protected Integer part1(List<Ticket> tickets) {
        return tickets.stream().mapToInt(Ticket::getSeatId).max()
                .orElseThrow(() -> new RuntimeException("There should be ticket seats "));
    }

    @Override
    protected Integer part2(List<Ticket> tickets) {
        TreeSet<Integer> sortedIds = tickets
                .stream()
                .map(Ticket::getSeatId)
                .collect(toCollection(TreeSet::new));

        int firstTicket = sortedIds.first() - 1;
        for (int seatId : sortedIds) {
            if (seatId != firstTicket + 1) {
                return firstTicket + 1;
            }
            firstTicket = seatId;
        }
        throw new RuntimeException(" all seats are taken");
    }

    public static void main(String[] args) {
        Day5 day05 = new Day5();
        List<Ticket> tickets = day05.getFileContent().map(Ticket::new).collect(toList());
        System.out.println(day05.part1(tickets));
        System.out.println(day05.part2(tickets));
    }
}
