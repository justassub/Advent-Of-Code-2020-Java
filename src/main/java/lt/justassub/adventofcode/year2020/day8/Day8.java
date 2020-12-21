package lt.justassub.adventofcode.year2020.day8;

import lt.justassub.adventofcode.year2020.Main2020;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

public class Day8 extends Main2020<List<String>, List<String>, Integer, Integer> {

    @Override
    public Integer part1(List<String> input) {
        List<Command> commands = input.stream()
                .map(CommandParser::parse)
                .collect(toList());
        return getInfiniteAndFiniteLoopAccumulator(commands);
    }


    @Override
    public Integer part2(List<String> input) {
        List<Command> commands = input.stream()
                .map(CommandParser::parse)
                .collect(toList());
        for (Command command : commands) {
            Instruction originalInstruction = command.getInstruction();
            if (isfiniteLoop(commands)) {
                return getInfiniteAndFiniteLoopAccumulator(commands);
            }

            if (originalInstruction == Instruction.NOP) {
                command.setInstruction(Instruction.JMP);
                if (isfiniteLoop(commands)) {
                    return getInfiniteAndFiniteLoopAccumulator(commands);
                }
            } else if (originalInstruction == Instruction.JMP) {
                command.setInstruction(Instruction.NOP);
                if (isfiniteLoop(commands)) {
                    return getInfiniteAndFiniteLoopAccumulator(commands);
                }
            }
            command.setInstruction(originalInstruction);

        }
        return null;
    }

    private int getInfiniteAndFiniteLoopAccumulator(List<Command> commands) {
        int answerAcc = 0;
        Set<CommandHistory> history = new HashSet<>();
        for (int i = 0; i < commands.size(); ) {
            Command currentCommand = commands.get(i);
            CommandHistory commandHistory = new CommandHistory(currentCommand, i);
            boolean historyContains = history.stream()
                    .anyMatch(commandHistory::equals);
            if (historyContains) {
                return answerAcc;
            }
            history.add(commandHistory);
            if (currentCommand.getInstruction().equals(Instruction.JMP)) {
                i += currentCommand.getValue();
                continue;
            } else if (currentCommand.getInstruction().equals(Instruction.ACC)) {
                answerAcc += currentCommand.getValue();
            }
            i++;
        }
        return answerAcc;
    }

    private boolean isfiniteLoop(List<Command> commands) {
        Set<CommandHistory> history = new HashSet<>();
        for (int i = 0; i < commands.size(); ) {
            Command currentCommand = commands.get(i);
            CommandHistory commandHistory = new CommandHistory(currentCommand, i);
            boolean historyContains = history.stream()
                    .anyMatch(commandHistory::equals);
            if (historyContains) {
                return false;
            }
            history.add(commandHistory);
            if (currentCommand.getInstruction().equals(Instruction.JMP)) {
                i += currentCommand.getValue();
                continue;
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        Day8 day8 = new Day8();
        List<String> info = day8.getFileContent().collect(toList());
        System.out.println(day8.part1(info));
        System.out.println(day8.part2(info));
    }
}
