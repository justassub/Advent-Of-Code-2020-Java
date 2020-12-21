package lt.justassub.adventofcode.year2020.day5;

public class Ticket {
    private byte row;
    private byte column;
    private String ticketId;
    private String columnIds;
    private String rowIds;
    private int seatId;


    public Ticket(String ticketId) {
        this.ticketId = ticketId;
        setUpColumnIdsAndRowIds();
        calculateAndSetUpColumn();
        calculateAndSetUpRow();
        calculateAndSetUpSeatId();
    }

    private void calculateAndSetUpSeatId() {
        int seatIdMultiplicationNumber = 8;
        this.seatId = seatIdMultiplicationNumber * row + column;
    }

    private void calculateAndSetUpColumn() {
        int maxColumn = 127;
        int minColumn = 0;
        int position = 0;
        while (position != columnIds.length()) {
            char nextPosition = columnIds.charAt(position);
            if (nextPosition == 'F') {
                maxColumn = (maxColumn + minColumn) / 2;
            }
            if (nextPosition == 'B') {
                minColumn = (maxColumn + minColumn) / 2 + 1;
            }
            position++;
        }
        if (maxColumn != minColumn) {
            throw new RuntimeException("maxColumn should be equal to min");
        }
        this.row = (byte) maxColumn;
    }

    private void calculateAndSetUpRow() {
        int maxRow = 7;
        int minRow = 0;
        int position = 0;
        while (position != rowIds.length()) {
            char nextPosition = rowIds.charAt(position);
            if (nextPosition == 'L') {
                maxRow = (maxRow + minRow) / 2;
            }
            if (nextPosition == 'R') {
                minRow = (maxRow + minRow) / 2 + 1;
            }
            position++;
        }
        if (maxRow != minRow) {
            throw new RuntimeException("maxRow should be equal to min");
        }
        this.column = (byte) maxRow;

    }

    private void setUpColumnIdsAndRowIds() {
        int firstPositionOfRowLetterR = ticketId.indexOf('R');
        int firstPositionOfRowLetterL = ticketId.indexOf('L');

        if (firstPositionOfRowLetterL < 0) {
            firstPositionOfRowLetterL = ticketId.length();
        }
        if (firstPositionOfRowLetterR < 0) {
            firstPositionOfRowLetterR = ticketId.length();
        }
        this.columnIds = ticketId.substring(0, Math.min(firstPositionOfRowLetterL, firstPositionOfRowLetterR));
        this.rowIds = ticketId.substring(Math.min(firstPositionOfRowLetterL, firstPositionOfRowLetterR));
    }

    public byte getRow() {
        return row;
    }

    public byte getColumn() {
        return column;
    }

    public int getSeatId() {
        return seatId;
    }
}

