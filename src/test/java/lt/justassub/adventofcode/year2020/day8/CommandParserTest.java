package lt.justassub.adventofcode.year2020.day8;

import org.junit.Assert;
import org.junit.Test;

public class CommandParserTest {
    @Test
    public void passJumpWithPositiveValue() {
        Command command = CommandParser.parse("jmp +254");
        Assert.assertEquals(Instruction.JMP, command.getInstruction());
        Assert.assertEquals(254, command.getValue());
    }
    @Test
    public void passNopWithNegativeValue() {
        Command command = CommandParser.parse("nop -150");
        Assert.assertEquals(Instruction.NOP, command.getInstruction());
        Assert.assertEquals(-150, command.getValue());
    }
    @Test
    public void passAccWithZeroValue() {
        Command command = CommandParser.parse("acc 0");
        Assert.assertEquals(Instruction.ACC, command.getInstruction());
        Assert.assertEquals(0, command.getValue());
    }

}
