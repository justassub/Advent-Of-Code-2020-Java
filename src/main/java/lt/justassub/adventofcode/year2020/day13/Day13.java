package lt.justassub.adventofcode.year2020.day13;

import lt.justassub.adventofcode.year2020.Main2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Day13 extends Main2020<Map.Entry<Integer, String>, Map.Entry<Integer, String>, Integer, Long> {
    @Override
    protected Integer part1(Map.Entry<Integer, String> input) {
        int timestamp = input.getKey();
        List<String> busIds = List.of(input.getValue().split(","));
        int misBusId = 0;
        int misBusTime = Integer.MAX_VALUE;
        for (String busId : busIds) {
            if ("x".equals(busId)) {
                continue;
            }
            int busIdInt = Integer.parseInt(busId);

            for (int i = timestamp; ; i++) {
                if (i % busIdInt == 0) {
                    if (i < misBusTime) {
                        misBusTime = i;
                        misBusId = busIdInt;
                    }
                    break;

                }
            }
        }
        return (misBusTime - timestamp) * misBusId;
    }

    @Override
    protected Long part2(Map.Entry<Integer, String> input) {
        List<Bus> busses = new ArrayList<>();
        int timestamp = input.getKey();
        List<String> busIds = List.of(input.getValue().split(","));

        int delay = 0;

        for (String busId : busIds) {
            if ("x".equals(busId)) {
                delay++;
                continue;
            }
            int busIdInt = Integer.parseInt(busId);

            Bus bus = new Bus(busIdInt, delay);
            busses.add(bus);
            delay++;
        }
        Bus earliestBus = busses.get(0);

        long earliestLeft = 500601154795914L;
        long earliest;
        Bus[] busArray = busses.toArray(Bus[]::new);
        outer:
        for (long i = earliestLeft; ; i += 29) {

            for (Bus bus : busArray) {
                if ((i + bus.getDelay()) % bus.getBusId() != 0) {
                    continue outer;
                }
            }
            earliest = i;
            break;
        }

        return earliest;


    }

    public static void main(String[] args) {
        Day13 day13 = new Day13();

        Map.Entry<Integer, String> stringStringEntry = Map.entry(
                1000001,
                "29,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,41,x,x,x,x,x,x,x,x,x,577,x,x,x,x,x,x,x,x,x,x,x,x,13,17,x,x,x,x,19,x,x,x,23,x,x,x,x,x,x,x,601,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,37");


        System.out.println(day13.part1(stringStringEntry));
        System.out.println(day13.part2(stringStringEntry));

    }
}
