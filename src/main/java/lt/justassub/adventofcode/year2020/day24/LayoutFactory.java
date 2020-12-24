package lt.justassub.adventofcode.year2020.day24;

import java.util.List;

import static lt.justassub.adventofcode.year2020.day24.Direction.*;

public class LayoutFactory {
    private final static List<Direction> DIRECTIONS = List.of(
            NORTH_WEST, NORTH_EAST, SOUTH_EAST, SOUTH_WEST,
            WEST, EAST
    );

    public static Layout buildLayout(String line) {
        Layout layout = new Layout();
        out:
        while (!line.isEmpty()) {
            for (Direction direction : DIRECTIONS) {
                String newLine = direction.move(layout, line);
                if (!newLine.equals(line)) {
                    line = newLine;
                    continue out;
                }
            }
        }
        return layout;
    }
}
