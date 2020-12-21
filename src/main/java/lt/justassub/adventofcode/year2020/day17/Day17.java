package lt.justassub.adventofcode.year2020.day17;

import lt.justassub.adventofcode.year2020.Main2020;

import java.util.HashSet;
import java.util.Set;

public class Day17 extends Main2020<String, String, Integer, Integer> {
    private final char activeSymbol = '#';

    @Override
    protected Integer part1(String input) {
        Set<Point3D> pointList = new HashSet<>();
        String[] splitLines = input.split("\n");
        for (int i = 0; i < splitLines.length; i++) {
            String line = splitLines[i];
            char[] chars = line.toCharArray();
            for (int k = 0; k < chars.length; k++) {
                if (chars[k] == activeSymbol) {
                    pointList.add(new Point3D(i, k, 0));
                }
            }
        }
        for (int i = 1; i < 7; i++) {
            pointList = changePoints3D(pointList);
        }


        return pointList.size();
    }

    protected Set<Point3D> changePoints3D(Set<Point3D> points) {
        Set<Point3D> updatedPoints = new HashSet<>();
        for (int x = -20; x < 20; x++) {
            for (int y = -20; y < 20; y++) {
                for (int z = -20; z < 20; z++) {
                    int activeClosePoints = Day17Util.returnHowActivePointsAreClose(x, y, z, points);
                    boolean shouldBecomeActive = activeClosePoints == 3;
                    boolean shouldKeepActive = activeClosePoints == 2 && points.contains(new Point3D(x, y, z));
                    if (shouldBecomeActive || shouldKeepActive) {
                        updatedPoints.add(new Point3D(x, y, z));
                    }

                }
            }
        }
        return updatedPoints;
    }


    @Override
    protected Integer part2(String input) {
        Set<Point4D> pointList = new HashSet<>();
        String[] splitLines = input.split("\n");
        for (int i = 0; i < splitLines.length; i++) {
            String line = splitLines[i];
            char[] chars = line.toCharArray();
            for (int k = 0; k < chars.length; k++) {
                if (chars[k] == activeSymbol) {
                    pointList.add(new Point4D(i, k, 0, 0));
                }
            }
        }
        for (int i = 1; i < 7; i++) {
            pointList = changePoints4D(pointList);
        }
        return pointList.size();
    }

    protected Set<Point4D> changePoints4D(Set<Point4D> points) {
        Set<Point4D> updatedPoints = new HashSet<>();
        for (int x = -20; x < 20; x++) {
            for (int y = -20; y < 20; y++) {
                for (int z = -20; z < 20; z++) {
                    for (int k = -20; k < 20; k++) {
                        int activeClosePoints = Day17Util.returnHowActivePointsAreClose(x, y, z, k, points);
                        boolean shouldBecomeActive = activeClosePoints == 3;
                        boolean shouldKeepActive = activeClosePoints == 2 && points.contains(new Point4D(x, y, z, k));

                        if (shouldBecomeActive || shouldKeepActive) {
                            updatedPoints.add(new Point4D(x, y, z, k));
                        }

                    }
                }
            }
        }
        return updatedPoints;
    }


    public static void main(String[] args) {
        Day17 day17 = new Day17();
        String text = """
                #####...
                .#..##..
                ##.##.##
                ...####.
                #.#...##
                .##...#.
                .#.#.###
                #.#.#..#
                """;
        System.out.println(day17.part1(text));
        System.out.println(day17.part2(text));
    }
}
