package lt.justassub.adventofcode.year2020.day20;

public class TileBuilder {
    public static Tile createTile(String s) {
        String[] info = s.split("\n");
        int id = Integer.parseInt(info[0].split("Tile ")[1].replace(":", ""));
        char[][] chars = new char[info.length - 1][];
        for (int i = 1; i < info.length; i++) {
            chars[i - 1] = info[i].toCharArray();
        }
        return new Tile(id, chars);
    }
}
