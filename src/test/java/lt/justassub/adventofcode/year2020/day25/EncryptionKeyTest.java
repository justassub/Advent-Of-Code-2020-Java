package lt.justassub.adventofcode.year2020.day25;

import org.junit.Assert;
import org.junit.Test;

public class EncryptionKeyTest {

    @Test
    public void part1Example1() {
        EncryptionKey encryptionKey = new EncryptionKey(5764801,14897079);
        encryptionKey.decryptData();
        Assert.assertEquals(8, encryptionKey.getLoop());
    }
    @Test
    public void part1Example2() {
        EncryptionKey encryptionKey = new EncryptionKey(17807724,14897079);
        encryptionKey.decryptData();
        Assert.assertEquals(11, encryptionKey.getLoop());
    }
}
