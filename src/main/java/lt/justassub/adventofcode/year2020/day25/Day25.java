package lt.justassub.adventofcode.year2020.day25;

import lombok.extern.log4j.Log4j2;
import lt.justassub.adventofcode.year2020.Main2020;

@Log4j2
public class Day25 extends Main2020<EncryptionKey, EncryptionKey, Long, Integer> {
    @Override
    protected Long part1(EncryptionKey input) {
        input.decryptData();
        return input.getEncryptionKey();
    }

    @Override
    protected Integer part2(EncryptionKey input) {
        return null;
    }

    public static void main(String[] args) {
        Day25 day25 = new Day25();
        EncryptionKey encryptionKey = new EncryptionKey(5290733, 15231938);
        log.info("Encryption key: {}", day25.part1(encryptionKey));
    }
}
