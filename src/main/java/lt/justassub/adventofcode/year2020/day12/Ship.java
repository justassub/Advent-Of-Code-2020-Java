package lt.justassub.adventofcode.year2020.day12;

public class Ship {
    protected int x;
    protected int y;

    private Directory facingDirectory = Directory.E;

    public void changeFacingDirectoryByDegrees(int facingDirectory) {

        this.facingDirectory = this.facingDirectory.addChangingDirectoryAndReturnNewDirectory(facingDirectory);
    }

    public void moveForward(int value) {

        moveToDirection(this.facingDirectory, value);
    }

    public void moveToDirection(Directory directory, int value) {
        switch (directory) {
            case N:
                setY(getY() + value);
                break;
            case E:
                setX(getX() + value);
                break;
            case S:
                setY(getY() - value);
                break;
            case W:
                setX(getX() - value);
                break;
            default:
                throw new RuntimeException("Something wrong..");
        }
    }

    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int calculateManhatanDistance() {
        return Math.abs(getX()) + Math.abs(getY());
    }
}
