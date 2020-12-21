package lt.justassub.adventofcode.year2020.day12;

public class WayPoint extends Ship {
    private int x = 10;
    private int y = 1;

    @Override
    public void changeFacingDirectoryByDegrees(int degrees) {
        degrees = Math.floorMod(degrees, 360);
        int copy = x; //
        switch (degrees) {
            case 0:
                break;
            case 180:
                x = -x;
                y = -y;
                break;
            case 90:
                x = y;
                y = -copy;
                break;
            case 270:
                x = -y;
                y = copy;
                break;

            default:
                throw new RuntimeException("Unsupported rotation degrees.");
        }
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    public void moveForward(int value) {
        super.x += this.x * value;
        super.y += this.y * value;
    }

    @Override
    public int calculateManhatanDistance() {
        return Math.abs(super.getX()) + Math.abs(super.getY());
    }
}
