package lt.justassub.adventofcode.year2020.day20;

public class Tile {
    private Long id;
    private char[][] content;

    private String topLine;
    private String bottomLine;
    private String leftLine;
    private String rightLine;

    public Tile(Long id, char[][] content) {
        this.id = id;
        this.content = content;
        topLine = String.valueOf(content[0]);
        bottomLine = String.valueOf(content[content.length - 1]);

        StringBuilder leftLine = new StringBuilder();
        StringBuilder rightLine = new StringBuilder();

        for (int i = 0; i < content.length; i++) {
            leftLine.append(content[i][0]);
            rightLine.append(content[i][content[i].length - 1]);
        }

        this.leftLine = leftLine.toString();
        this.rightLine = rightLine.toString();


    }


    public Long getId() {
        return id;
    }


    public Match combines(Tile t) {
        if (this.rightLine.equals(t.leftLine)) {
            return Match.RIGHT;
        }
        if (this.leftLine.equals(t.rightLine)) {
            return Match.LEFT;
        }
        if (this.topLine.equals(t.bottomLine)) {
            return Match.TOP;
        }
        if (this.bottomLine.equals(t.bottomLine)) {
            return Match.BOTTOM;
        }
        return null;
    }
}
