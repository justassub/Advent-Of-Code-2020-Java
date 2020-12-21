package lt.justassub.adventofcode.year2020.day8;

public class CommandParser {

    public static Command parse(String lineToParse) {
        String[] values = lineToParse.split(" ");
        Instruction instruction;
        int value = Integer.parseInt(values[1]);
        switch (values[0].toLowerCase()) {
            case "jmp":
                instruction = Instruction.JMP;
                break;
            case "acc":
                instruction = Instruction.ACC;
                break;
            case "nop":
                instruction = Instruction.NOP;
                break;
            default:
                throw new RuntimeException("Unknow instruction");
        }
        return new Command(value, instruction);
    }
}
