package lt.justassub.adventofcode.year2020.day11;

import lt.justassub.adventofcode.year2020.Main2020;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static lt.justassub.adventofcode.year2020.day11.Seat.*;

public class Day11 extends Main2020<List<String>, List<String>, Long, Long> {
    @Override
    protected Long part1(List<String> input) {

        List<List<Seat>> seats = input.stream()
                .map(l -> Stream.of(l.split("")))
                .map(s -> s.map(this::transformLetterToPosition).collect(toList()))
                .collect(toList());


        return calculate1(seats);
    }

    private long calculate1(List<List<Seat>> seats) {

        int firstRow = 0;
        int lastRow = seats.size() - 1;
        int firstPosition = 0;
        int lastPosition = seats.get(firstRow).size() - 1;

        boolean seatsChanged = false;

        List<List<Seat>> newSeats = new ArrayList<>();

        for (int i = firstRow; i <= lastRow; i++) {
            for (int k = firstPosition; k <= lastPosition; k++) {
                List<Seat> adjancedSeats = new ArrayList<>();
                Seat currentSeat = seats.get(i).get(k);
                if (k == 0) {
                    newSeats.add(new ArrayList<>());
                }
                if (i == 0 && k == 0) {
                    Seat s1 = seats.get(i).get(k + 1);
                    Seat s2 = seats.get(i).get(k);
                    Seat s3 = seats.get(i).get(k + 1);
                    adjancedSeats.add(s1);
                    adjancedSeats.add(s2);
                    adjancedSeats.add(s3);
                } else if (i == 0 && k == lastPosition) {
                    Seat s1 = seats.get(i).get(k - 1);
                    Seat s2 = seats.get(i + 1).get(k);
                    Seat s3 = seats.get(i + 1).get(k - 1);
                    adjancedSeats.add(s1);
                    adjancedSeats.add(s2);
                    adjancedSeats.add(s3);
                } else if (i == lastRow && k == 0) {
                    Seat s1 = seats.get(i - 1).get(0);
                    Seat s2 = seats.get(i - 1).get(k + 1);
                    Seat s3 = seats.get(i).get(k + 1);
                    adjancedSeats.add(s1);
                    adjancedSeats.add(s2);
                    adjancedSeats.add(s3);
                } else if (i == lastRow && k == lastPosition) {
                    Seat s1 = seats.get(i - 1).get(k);
                    Seat s2 = seats.get(i - 1).get(k - 1);
                    Seat s3 = seats.get(i).get(k - 1);
                    adjancedSeats.add(s1);
                    adjancedSeats.add(s2);
                    adjancedSeats.add(s3);
                } else if (i == 0) {
                    Seat s1 = seats.get(i).get(k - 1);
                    Seat s2 = seats.get(i).get(k + 1);

                    Seat s3 = seats.get(i + 1).get(k - 1);
                    Seat s4 = seats.get(i + 1).get(k);
                    Seat s5 = seats.get(i + 1).get(k + 1);

                    adjancedSeats.add(s1);
                    adjancedSeats.add(s2);
                    adjancedSeats.add(s3);
                    adjancedSeats.add(s4);
                    adjancedSeats.add(s5);
                } else if (i == lastRow) {
                    Seat s1 = seats.get(i).get(k - 1);
                    Seat s2 = seats.get(i).get(k + 1);

                    Seat s3 = seats.get(i - 1).get(k - 1);
                    Seat s4 = seats.get(i - 1).get(k);
                    Seat s5 = seats.get(i - 1).get(k + 1);

                    adjancedSeats.add(s1);
                    adjancedSeats.add(s2);
                    adjancedSeats.add(s3);
                    adjancedSeats.add(s4);
                    adjancedSeats.add(s5);
                } else if (k == firstPosition) {
                    Seat s1 = seats.get(i).get(k + 1);

                    Seat s2 = seats.get(i - 1).get(k);
                    Seat s3 = seats.get(i + 1).get(k);

                    Seat s4 = seats.get(i - 1).get(k + 1);
                    Seat s5 = seats.get(i + 1).get(k + 1);

                    adjancedSeats.add(s1);
                    adjancedSeats.add(s2);
                    adjancedSeats.add(s3);
                    adjancedSeats.add(s4);
                    adjancedSeats.add(s5);
                } else if (k == lastPosition) {
                    Seat s1 = seats.get(i).get(k - 1);

                    Seat s2 = seats.get(i - 1).get(k);
                    Seat s3 = seats.get(i + 1).get(k);

                    Seat s4 = seats.get(i - 1).get(k - 1);
                    Seat s5 = seats.get(i + 1).get(k - 1);

                    adjancedSeats.add(s1);
                    adjancedSeats.add(s2);
                    adjancedSeats.add(s3);
                    adjancedSeats.add(s4);
                    adjancedSeats.add(s5);
                } else {
                    Seat s1 = seats.get(i).get(k + 1);
                    Seat s2 = seats.get(i).get(k - 1);

                    Seat s3 = seats.get(i + 1).get(k);
                    Seat s4 = seats.get(i - 1).get(k);

                    Seat s5 = seats.get(i + 1).get(k + 1);
                    Seat s6 = seats.get(i + 1).get(k - 1);

                    Seat s7 = seats.get(i - 1).get(k + 1);
                    Seat s8 = seats.get(i - 1).get(k - 1);
                    adjancedSeats.add(s1);
                    adjancedSeats.add(s2);
                    adjancedSeats.add(s3);
                    adjancedSeats.add(s4);
                    adjancedSeats.add(s5);
                    adjancedSeats.add(s6);
                    adjancedSeats.add(s7);
                    adjancedSeats.add(s8);
                }
                Seat newSeat = changeInto(currentSeat, adjancedSeats, 4);

                if (newSeat != currentSeat) {
                    seatsChanged = true;
                }

                newSeats.get(i).add(newSeat);


            }
        }
        if (!seatsChanged) {
            return seats.stream()
                    .map(s -> s.stream().filter(OCCUPIED::equals).count())
                    .reduce(0L, Long::sum);
        }

        return calculate1(newSeats);
    }

    private long calculate2(List<List<Seat>> seats) {

        int firstRow = 0;
        int lastRow = seats.size() - 1;
        int firstPosition = 0;
        int lastPosition = seats.get(firstRow).size() - 1;

        boolean seatsChanged = false;

        List<List<Seat>> newSeats = new ArrayList<>();

        for (int i = firstRow; i <= lastRow; i++) {
            for (int k = firstPosition; k <= lastPosition; k++) {
                List<Seat> adjancedSeats = new ArrayList<>();
                Seat currentSeat = seats.get(i).get(k);
                if (k == 0) {
                    newSeats.add(new ArrayList<>());
                }


                if (i == 0 && k == 0) {
                    Seat s1 = FLOOR;
                    Seat s2 = FLOOR;
                    Seat s3 = FLOOR;


                    for (int eyesPosition = 1; eyesPosition <= lastPosition; eyesPosition++) {
                        Seat s = seats.get(i).get(eyesPosition);

                        if (s != FLOOR) {
                            s1 = s;
                            break;
                        }
                    }
                    for (int eyesPosition = 1; eyesPosition <= lastRow; eyesPosition++) {
                        Seat s = seats.get(eyesPosition).get(i);
                        if (s != FLOOR) {
                            s2 = s;
                            break;
                        }
                    }
                    for (int eyesPosition = 1; eyesPosition <= lastPosition && eyesPosition <= lastRow; eyesPosition++) {
                        Seat s = seats.get(eyesPosition).get(eyesPosition);

                        if (s != FLOOR) {
                            s3 = s;
                            break;
                        }
                    }

                    adjancedSeats.add(s1);
                    adjancedSeats.add(s2);
                    adjancedSeats.add(s3);
                } else if (i == 0 && k == lastPosition) {
                    Seat s1 = FLOOR;
                    Seat s2 = FLOOR;
                    Seat s3 = FLOOR;

                    for (int eyesPosition = k - 1; eyesPosition >= 0; eyesPosition--) {
                        Seat s = seats.get(i).get(eyesPosition);

                        if (s != FLOOR) {
                            s1 = s;
                            break;
                        }
                    }

                    for (int eyesPosition = 0; eyesPosition <= lastRow; eyesPosition++) {
                        Seat s = seats.get(eyesPosition).get(k);

                        if (s != FLOOR) {
                            s2 = s;
                            break;
                        }
                    }
                    for (int eyesPosition = lastPosition - 1, z = 1; eyesPosition >= 0 && z <= lastRow; eyesPosition--, z++) {
                        Seat s = seats.get(z).get(eyesPosition);

                        if (s != FLOOR) {
                            s3 = s;
                            break;
                        }
                    }
                    adjancedSeats.add(s1);
                    adjancedSeats.add(s2);
                    adjancedSeats.add(s3);
                } else if (i == lastRow && k == 0) {

                    Seat s1 = FLOOR;
                    Seat s2 = FLOOR;
                    Seat s3 = FLOOR;


                    for (int eyesPosition = lastRow - 1; eyesPosition >= 0; eyesPosition--) {
                        Seat s = seats.get(eyesPosition).get(k);
                        if (s != FLOOR) {
                            s1 = s;
                            break;
                        }
                    }

                    for (int eyesPosition = 1; eyesPosition <= lastPosition; eyesPosition++) {
                        Seat s = seats.get(i).get(eyesPosition);
                        if (s != FLOOR) {
                            s2 = s;
                            break;
                        }
                    }
                    for (int eyesPosition = lastRow - 1, z = 1; z <= lastPosition && eyesPosition >= 0; eyesPosition--, z++) {
                        Seat s = seats.get(eyesPosition).get(z);

                        if (s != FLOOR) {
                            s3 = s;
                            break;
                        }
                    }


                    adjancedSeats.add(s1);
                    adjancedSeats.add(s2);
                    adjancedSeats.add(s3);
                } else if (i == lastRow && k == lastPosition) {
                    Seat s1 = FLOOR;
                    Seat s2 = FLOOR;
                    Seat s3 = FLOOR;


                    for (int eyesPosition = lastRow - 1; eyesPosition >= 0; eyesPosition--) {
                        Seat s = seats.get(eyesPosition).get(k);
                        if (s != FLOOR) {
                            s1 = s;
                            break;
                        }
                    }

                    for (int eyesPosition = lastPosition - 1; eyesPosition >= 0; eyesPosition--) {
                        Seat s = seats.get(i).get(eyesPosition);
                        if (s != FLOOR) {
                            s2 = s;
                            break;
                        }
                    }
                    for (int eyesPosition = lastPosition - 1, z = lastRow; eyesPosition >= 0 && z >= 0; eyesPosition--, z--) {
                        Seat s = seats.get(z).get(eyesPosition);

                        if (s != FLOOR) {
                            s3 = s;
                            break;
                        }
                    }

                    adjancedSeats.add(s1);
                    adjancedSeats.add(s2);
                    adjancedSeats.add(s3);
                } else if (i == 0) {

                    Seat s1 = FLOOR;//seats.get(i).get(k - 1);
                    Seat s2 = FLOOR;

                    Seat s3 = FLOOR;
                    Seat s4 = FLOOR;
                    Seat s5 = FLOOR;


                    for (int eyesPosition = i + 1; eyesPosition <= lastRow; eyesPosition++) { // zemyn
                        Seat s = seats.get(eyesPosition).get(k);
                        if (s != FLOOR) {
                            s1 = s;
                            break;
                        }
                    }
                    for (int eyesPosition = k - 1; eyesPosition >= 0; eyesPosition--) { // kaire
                        Seat s = seats.get(i).get(eyesPosition);
                        if (s != FLOOR) {
                            s2 = s;
                            break;
                        }
                    }

                    for (int eyesPosition = k + 1; eyesPosition <= lastPosition; eyesPosition++) { // desine
                        Seat s = seats.get(i).get(eyesPosition);
                        if (s != FLOOR) {
                            s3 = s;
                            break;
                        }
                    }


                    for (int x = k - 1, y = 1; x >= 0 && y <= lastRow; x++, y++) { // zemyn kaire
                        Seat s = seats.get(y).get(x);
                        if (s != FLOOR) {
                            s4 = s;
                            break;
                        }
                    }
                    for (int x = k + 1, y = 1; x <= lastPosition && y <= lastRow; x++, y++) { // zemyn desine
                        Seat s = seats.get(y).get(x);
                        if (s != FLOOR) {
                            s5 = s;
                            break;
                        }
                    }


                    adjancedSeats.add(s1);
                    adjancedSeats.add(s2);
                    adjancedSeats.add(s3);
                    adjancedSeats.add(s4);
                    adjancedSeats.add(s5);
                } else if (i == lastRow) {


                    Seat s1 = FLOOR;
                    Seat s2 = FLOOR;

                    Seat s3 = FLOOR;
                    Seat s4 = FLOOR;
                    Seat s5 = FLOOR;

                    for (int y = i - 1; y >= 0; y--) { // aukstyn
                        Seat s = seats.get(y).get(k);
                        if (s != FLOOR) {
                            s1 = s;
                            break;
                        }
                    }
                    for (int eyesPosition = k - 1; eyesPosition >= 0; eyesPosition--) { // kaire
                        Seat s = seats.get(i).get(eyesPosition);
                        if (s != FLOOR) {
                            s2 = s;
                            break;
                        }
                    }
                    for (int eyesPosition = k + 1; eyesPosition <= lastPosition; eyesPosition++) { // desine
                        Seat s = seats.get(i).get(eyesPosition);
                        if (s != FLOOR) {
                            s3 = s;
                            break;
                        }
                    }
                    for (int x = k - 1, y = i - 1; x >= 0 && y >= 0; x++, y--) { // aukstyn kaire
                        Seat s = seats.get(y).get(x);
                        if (s != FLOOR) {
                            s4 = s;
                            break;
                        }
                    }
                    for (int x = k + 1, y = i - 1; x <= lastPosition && y >= 0; x++, y--) { // aukstyn desine
                        Seat s = seats.get(y).get(x);
                        if (s != FLOOR) {
                            s5 = s;
                            break;
                        }
                    }
                    adjancedSeats.add(s1);
                    adjancedSeats.add(s2);
                    adjancedSeats.add(s3);
                    adjancedSeats.add(s4);
                    adjancedSeats.add(s5);
                } else if (k == firstPosition) {
                    Seat s1 = FLOOR;

                    Seat s2 = FLOOR;
                    Seat s3 = FLOOR;

                    Seat s4 = FLOOR;
                    Seat s5 = FLOOR;


                    for (int y = i - 1; y >= 0; y--) { // aukstyn
                        Seat s = seats.get(y).get(k);
                        if (s != FLOOR) {
                            s1 = s;
                            break;
                        }
                    }

                    for (int eyesPosition = i + 1; eyesPosition <= lastRow; eyesPosition++) { // zemyn
                        Seat s = seats.get(eyesPosition).get(k);
                        if (s != FLOOR) {
                            s2 = s;
                            break;
                        }
                    }

                    for (int eyesPosition = k + 1; eyesPosition <= lastPosition; eyesPosition++) { // desine
                        Seat s = seats.get(i).get(eyesPosition);
                        if (s != FLOOR) {
                            s3 = s;
                            break;
                        }
                    }
                    for (int x = 1, y = i + 1; x <= lastPosition && y <= lastRow; x++, y++) { // zemyn desine
                        Seat s = seats.get(y).get(x);
                        if (s != FLOOR) {
                            s4 = s;
                            break;
                        }
                    }
                    for (int x = 1, y = i - 1; x <= lastPosition && y >= 0; x++, y--) { // aukstyn desine
                        Seat s = seats.get(y).get(x);
                        if (s != FLOOR) {
                            s5 = s;
                            break;
                        }
                    }

                    adjancedSeats.add(s1);
                    adjancedSeats.add(s2);
                    adjancedSeats.add(s3);
                    adjancedSeats.add(s4);
                    adjancedSeats.add(s5);
                } else if (k == lastPosition) {
                    Seat s1 = FLOOR;

                    Seat s2 = FLOOR;
                    Seat s3 = FLOOR;

                    Seat s4 = FLOOR;
                    Seat s5 = FLOOR;

                    for (int y = i - 1; y >= 0; y--) { // aukstyn
                        Seat s = seats.get(y).get(k);
                        if (s != FLOOR) {
                            s1 = s;
                            break;
                        }
                    }

                    for (int eyesPosition = i + 1; eyesPosition <= lastRow; eyesPosition++) { // zemyn
                        Seat s = seats.get(eyesPosition).get(k);
                        if (s != FLOOR) {
                            s2 = s;
                            break;
                        }
                    }

                    for (int eyesPosition = k - 1; eyesPosition >= 0; eyesPosition--) { // kaire
                        Seat s = seats.get(i).get(eyesPosition);
                        if (s != FLOOR) {
                            s3 = s;
                            break;
                        }
                    }

                    for (int x = k - 1, y = i + 1; x >= 0 && y <= lastRow; x--, y++) { // zemyn kaire
                        Seat s = seats.get(y).get(x);
                        if (s != FLOOR) {
                            s4 = s;
                            break;
                        }
                    }
                    for (int x = k - 1, y = i - 1; x >= 0 && y >= 0; x--, y--) { // aukstyn  kaire
                        Seat s = seats.get(y).get(x);
                        if (s != FLOOR) {
                            s5 = s;
                            break;
                        }
                    }
                    adjancedSeats.add(s1);
                    adjancedSeats.add(s2);
                    adjancedSeats.add(s3);
                    adjancedSeats.add(s4);
                    adjancedSeats.add(s5);
                } else {
                    Seat s1 = FLOOR;
                    Seat s2 = FLOOR;

                    Seat s3 = FLOOR;
                    Seat s4 = FLOOR;

                    Seat s5 = FLOOR;
                    Seat s6 = FLOOR;

                    Seat s7 = FLOOR;
                    Seat s8 = FLOOR;


                    for (int y = i - 1; y >= 0; y--) { // aukstyn
                        Seat s = seats.get(y).get(k);
                        if (s != FLOOR) {
                            s1 = s;
                            break;
                        }
                    }

                    for (int eyesPosition = i + 1; eyesPosition <= lastRow; eyesPosition++) { // zemyn
                        Seat s = seats.get(eyesPosition).get(k);
                        if (s != FLOOR) {
                            s2 = s;
                            break;
                        }
                    }

                    for (int eyesPosition = k - 1; eyesPosition >= 0; eyesPosition--) { // kaire
                        Seat s = seats.get(i).get(eyesPosition);
                        if (s != FLOOR) {
                            s3 = s;
                            break;
                        }
                    }


                    for (int eyesPosition = k + 1; eyesPosition <= lastPosition; eyesPosition++) { // desine
                        Seat s = seats.get(i).get(eyesPosition);
                        if (s != FLOOR) {
                            s4 = s;
                            break;
                        }
                    }

                    for (int x = k - 1, y = i + 1; x >= 0 && y <= lastRow; x--, y++) { // zemyn kaire
                        Seat s = seats.get(y).get(x);
                        if (s != FLOOR) {
                            s5 = s;
                            break;
                        }
                    }
                    for (int x = k - 1, y = i - 1; x >= 0 && y >= 0; x--, y--) { // aukstyn  kaire

                        Seat s = seats.get(y).get(x);

                        if (s != FLOOR) {
                            s6 = s;
                            break;
                        }
                    }
                    for (int x = k+1, y = i + 1; x <= lastPosition && y <= lastRow; x++, y++) { // zemyn desine
                        Seat s = seats.get(y).get(x);
                        if (s != FLOOR) {
                            s7 = s;
                            break;
                        }
                    }
                    for (int x = k+1, y = i - 1; x <= lastPosition && y >= 0; x++, y--) { // aukstyn desine
                        Seat s = seats.get(y).get(x);
                        if (s != FLOOR) {
                            s8 = s;
                            break;
                        }
                    }
                    if (k == 8 && i == 1) {
                        System.out.println("");
                    }
                    adjancedSeats.add(s1);
                    adjancedSeats.add(s2);
                    adjancedSeats.add(s3);
                    adjancedSeats.add(s4);
                    adjancedSeats.add(s5);
                    adjancedSeats.add(s6);
                    adjancedSeats.add(s7);
                    adjancedSeats.add(s8);
                }


                Seat newSeat = changeInto(currentSeat, adjancedSeats, 5);

                if (newSeat != currentSeat) {
                    seatsChanged = true;
                }

                newSeats.get(i).add(newSeat);

            }
        }
        if (!seatsChanged) {
            return seats.stream()
                    .map(s -> s.stream().filter(OCCUPIED::equals).count())
                    .reduce(0L, Long::sum);
        }

        return calculate2(newSeats);
    }


    private Seat changeInto(Seat position, List<Seat> adjancedSeats, int maxAmountAllowed) {
        if (position == FLOOR) {
            return position;
        }
        if (position == EMPTY && !adjancedSeats.contains(OCCUPIED)) {
            return OCCUPIED;
        }
        if (position == OCCUPIED && adjancedSeats.stream().filter(OCCUPIED::equals).count() >= maxAmountAllowed) {
            return EMPTY;
        }
        return position;
    }

    private Seat transformLetterToPosition(String letter) {
        if (letter.length() > 1) {
            throw new RuntimeException("Bad input");
        }
        switch (letter) {
            case "L":
                return EMPTY;
            case "#":
                return OCCUPIED;
            case ".":
                return FLOOR;
            default:
                return null;
        }

    }


    @Override
    protected Long part2(List<String> input) {
        List<List<Seat>> seats = input.stream()
                .map(l -> Stream.of(l.split("")))
                .map(s -> s.map(this::transformLetterToPosition).collect(toList()))
                .collect(toList());


        return calculate2(seats);
    }

    public static void main(String[] args) {
        Day11 day11 = new Day11();
        List<String> info = day11.getFileContent().collect(toList());
        // System.out.println(day11.part1(info));
        System.out.println(day11.part2(info));
    }
}
