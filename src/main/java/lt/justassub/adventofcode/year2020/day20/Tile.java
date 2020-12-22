package lt.justassub.adventofcode.year2020.day20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public record Tile(int id, char[][] content) {

    public int matches(List<Tile> tiles) {
        List<char[]> edgeArrays = getEdgeArrays();
        int count = 0;
        for (Tile tile : tiles) {
            if (tile.id == this.id) {
                continue;
            }
            for (char[] possibleEdgeMatch : tile.getEdgeArrays()) {
                for (char[] myEdgeArray : edgeArrays) {
                    if ((Arrays.equals(possibleEdgeMatch, myEdgeArray) || Arrays.equals(myEdgeArray, reverse(possibleEdgeMatch)))) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private char[] reverse(char[] arr) {
        char[] tmpArray = new char[content.length];
        for (int i = 0; i < arr.length; i++) {
            tmpArray[i] = arr[arr.length - i - 1];
        }
        return tmpArray;
    }

    private List<char[]> getEdgeArrays() {
        List<char[]> edgeArrays = new ArrayList<>();
        edgeArrays.add(content[0]);
        edgeArrays.add(content[content.length - 1]);
        char[][] transposedGrid = transposeGrid(content);
        edgeArrays.add(transposedGrid[0]);
        edgeArrays.add(transposedGrid[content.length - 1]);
        return edgeArrays;
    }

    public static char[][] transposeGrid(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        char[][] transposed = new char[n][m];

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                transposed[x][y] = grid[y][x];
            }
        }

        return transposed;
    }
}
