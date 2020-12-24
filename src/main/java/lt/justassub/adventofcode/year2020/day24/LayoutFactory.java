package lt.justassub.adventofcode.year2020.day24;

import static lt.justassub.adventofcode.year2020.day24.Constants.DIRECTIONS;

public class LayoutFactory {


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
