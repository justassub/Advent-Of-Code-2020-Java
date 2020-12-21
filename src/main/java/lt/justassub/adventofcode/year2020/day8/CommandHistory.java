package lt.justassub.adventofcode.year2020.day8;

public class CommandHistory {
    private Command command;
    private int index;

    public CommandHistory(Command command, int index) {
        this.command = command;
        this.index = index;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public int getIndex() {
        return index;
    }



    public boolean equals(CommandHistory obj) {
        return obj.getIndex() == this.getIndex() &&
                obj.getCommand().getInstruction() == this.getCommand().getInstruction() &&
                obj.getCommand().getValue() == this.getCommand().getValue();
    }
}
