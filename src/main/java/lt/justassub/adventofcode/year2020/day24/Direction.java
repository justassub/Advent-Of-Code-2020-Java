package lt.justassub.adventofcode.year2020.day24;

public enum Direction {
    WEST("w", -2, 0),

    EAST("e", 2, 0),
    NORTH_WEST("nw", -1, 1),
    NORTH_EAST("ne", 1, 1),
    SOUTH_WEST("sw", -1, -1),
    SOUTH_EAST("se", 1, -1);

    private final String directionStart;
    private final int changesToX;
    private final int changesToY;

    Direction(String directionStart, int x, int y) {
        this.directionStart = directionStart;
        this.changesToX = x;
        this.changesToY = y;
    }

    public String move(Layout layout, String line) {
        if (line.startsWith(directionStart)) {
            layout.addToX(changesToX);
            layout.addToY(changesToY);
            return line.substring(directionStart.length());
        } else {
            return line;
        }
    }

    public Layout getNewLayoutIntoThatDirection(Layout layout) {
        return new Layout(layout.getX() + changesToX, layout.getY() + changesToY);

    }

}
