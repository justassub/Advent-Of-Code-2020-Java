package lt.justassub.adventofcode.year2020.day17;

import java.util.Set;

public class Day17Util {
    public static int returnHowActivePointsAreClose(int x, int y, int z, Set<Point3D> points) {
        int activePointsClose = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                for (int k = z - 1; k <= z + 1; k++) {
                    Point3D point = new Point3D(i, j, k);
                    if (points.contains(point)) {
                        activePointsClose++;
                    }
                }
            }
        }
        if (points.contains(new Point3D(x, y, z))) {
            activePointsClose--;
        }
        return activePointsClose;
    }

    public static int returnHowActivePointsAreClose(int x, int y, int z, int t, Set<Point4D> points) {
        int activePointsClose = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                for (int k = z - 1; k <= z + 1; k++) {
                    for (int m = t - 1; m <= t + 1; m++) {
                        Point4D point = new Point4D(i, j, k, m);
                        if (points.contains(point)) {
                            activePointsClose++;
                        }
                    }
                }
            }
        }
        if (points.contains(new Point4D(x, y, z, t))) {
            activePointsClose--;
        }
        return activePointsClose;
    }

}
