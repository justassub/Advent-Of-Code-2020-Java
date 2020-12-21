package lt.justassub.adventofcode.year2020.day7.domain;

public class BagParserExeception extends RuntimeException {
    public BagParserExeception() {
        super("Bags can not be parsed properly.");
    }
}
