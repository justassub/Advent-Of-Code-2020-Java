package lt.justassub.adventofcode.year2020.day20;


import lt.justassub.adventofcode.year2020.Main2020;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Day20 extends Main2020<String, String, Long, Long> {


    @Override
    protected Long part1(String input) {
        List<Tile> tileList = Arrays.stream(input.split(
                "\n" +
                "\n"))
                .map(TileBuilder::createTile)
                .collect(Collectors.toList());

        return findCorners(tileList).stream()
                .mapToLong(Tile::id)
                .reduce(1L, (v, id) -> v * id);
    }

    private Set<Tile> findCorners(List<Tile> tileList) {
        Set<Tile> corners = new HashSet<>();

        for (Tile t : tileList) {
            if (t.matches(tileList) == 2) {
                corners.add(t);
            }
        }
        if (corners.size() != 4) {
            throw new RuntimeException("");
        }
        return corners;
    }

    @Override
    protected Long part2(String input) {

        //TODO never
        return null;
    }

    public static void main(String[] args) {
        Day20 day20 = new Day20();
        String content = day20.getFileContent().collect(Collectors.joining("\n"));
        System.out.println(day20.part1(content));
    }
}
