package lt.justassub.adventofcode.year2020.day14;

import org.junit.Assert;
import org.junit.Test;

public class MemoryBlockTest {
    @Test
    public void calculateBinaryValueCorrectly() {
        MemoryBlock memoryBlock = new MemoryBlock(8, 11);
        Assert.assertEquals(8, memoryBlock.getMemoryBlockIndex());
        Assert.assertEquals("000000000000000000000000000000001011", memoryBlock.getBinaryString());
    }
    @Test
    public void calculateBinaryValueCorrectly2() {
        MemoryBlock memoryBlock = new MemoryBlock(7, 101);
        Assert.assertEquals(7, memoryBlock.getMemoryBlockIndex());
        Assert.assertEquals("000000000000000000000000000001100101", memoryBlock.getBinaryString());
    }
}
