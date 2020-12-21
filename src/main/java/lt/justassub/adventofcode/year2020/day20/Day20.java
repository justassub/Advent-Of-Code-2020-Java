package lt.justassub.adventofcode.year2020.day20;


import lt.justassub.adventofcode.year2020.Main2020;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class Day20 extends Main2020<String, String, Long, Long> {


    @Override
    protected Long part1(String input) {
        List<Tile> tileList = Arrays.stream(input.split(
                "\n" +
                        "\n"))
                .map(TileBuilder::createTile)
                .collect(Collectors.toList());

        Map<Tile, List<Match>> info = getMatchers(tileList);
        return null;
    }

    private Map<Tile, List<Match>> getMatchers(List<Tile> tileList) {
        Map<Tile, List<Match>> matches = new HashMap<>();
        for (Tile tile : tileList) {
            matches.put(tile, new ArrayList<>());

            for (Tile t : tileList) {

                if (tile == t) {
                    continue;
                }
                Match match = tile.combines(t);
                if (match != null) {
                    matches.get(tile).add(match);
                }
            }
        }

        return matches;
    }

    @Override
    protected Long part2(String input) {
        return null;
    }

    public static void main(String[] args) {
        Day20 day20 = new Day20();
        String content = day20.getFileContent().collect(Collectors.joining("\n"));
        System.out.println(day20.part1(content));
    }
}
