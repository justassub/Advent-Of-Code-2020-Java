package lt.justassub.adventofcode.year2020.day14;

import static lt.justassub.adventofcode.year2020.day14.Day14Util.generateBinaryValue;

public class MemoryBlock {
    private int memoryBlockIndex;
    private String binaryString;


    public MemoryBlock(int memoryBlockIndex, long decimalValue) {
        this.memoryBlockIndex = memoryBlockIndex;
        this.binaryString = generateBinaryValue(decimalValue);
    }

    public int getMemoryBlockIndex() {
        return memoryBlockIndex;
    }
    public String getBinaryString() {
        return binaryString;
    }

}
