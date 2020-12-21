package lt.justassub.adventofcode.year2020.day12;

import lt.justassub.adventofcode.year2020.Main2020;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Day12 extends Main2020<List<String>, List<String>, Integer, Integer> {


    @Override
    protected Integer part1(List<String> input) {
        Ship ship = new Ship();
        return calculateManhatanDistance(ship, input);
    }

    @Override
    protected Integer part2(List<String> input) {
        Ship ship = new WayPoint();
        return calculateManhatanDistance(ship, input);
    }

    private Integer calculateManhatanDistance(Ship ship, List<String> input) {
        for (String line : input) {
            String directory = "" + line.charAt(0);
            int value = Integer.parseInt(line.substring(1));
            if (checkIfDirection(directory)) {
                ship.moveToDirection(Directory.valueOf(directory), value);
                continue;
            }
            if (checkIfChangeFacing(directory)) {
                Trajectory t = Trajectory.valueOf(directory);
                if (t == Trajectory.L) {
                    ship.changeFacingDirectoryByDegrees(-value);
                } else {
                    ship.changeFacingDirectoryByDegrees(value);
                }
            }
            if ("F".equals(directory)) {
                ship.moveForward(value);
            }
        }

        return ship.calculateManhatanDistance();
    }

    private boolean checkIfDirection(String input) {
        for (Directory d : Directory.values()) {
            if (d.name().equals(input)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkIfChangeFacing(String input) {
        for (Trajectory t : Trajectory.values()) {
            if (input.equals(t.name())) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Day12 day12 = new Day12();
        List<String> info = day12.getFileContent().collect(toList());
        System.out.println(day12.part1(info));
        System.out.println(day12.part2(info));
    }
}
