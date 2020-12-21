package lt.justassub.adventofcode.year2020.day12;

public enum Directory {
    N(0), E(90), S(180), W(270);

    private int degree;

    Directory(int degrees) {
        this.degree = degrees;
    }

    public Directory addChangingDirectoryAndReturnNewDirectory(int degree) {
        int answer = Math.floorMod(this.degree + degree, 360);
        switch (answer) {
            case 0:
                return N;
            case 90:
                return E;
            case 180:
                return S;
            case 270:
                return W;
            default:
                throw new RuntimeException();
        }

    }

}
