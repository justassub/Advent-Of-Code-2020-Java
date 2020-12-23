package lt.justassub.adventofcode.year2020.day23;

import java.util.LinkedList;
import java.util.stream.IntStream;

public class CupGame {
    private final int movesToPlay;
    private LinkedList<Integer> numbers;

    private final int minNumber;
    private final int maxNumber;

   private final int pickedNumbers = 3;

    public CupGame(int movesToPlay, LinkedList<Integer> integers) {
        this.movesToPlay = movesToPlay;
        this.numbers = new LinkedList<>(integers);
        minNumber = findMin();
        maxNumber = findMax();
    }

    public LinkedList<Integer> playGame() {
        IntStream.range(0, movesToPlay)
                .forEach(__ -> playOneRound());
        return numbers;
    }

    private void playOneRound() {

        int currentNumber = numbers.pop();
        LinkedList<Integer> pickedUpNumbers = new LinkedList<>();
        for (int i = 0; i < pickedNumbers; i++) {
            pickedUpNumbers.add(numbers.pop());
        }
        int destination = currentNumber;
        do {
            --destination;
            if (destination < minNumber) {
                destination = maxNumber;
            }
        } while (!numbers.contains(destination));

        int destinationIndex = numbers.indexOf(destination);
        for (int i = destinationIndex; i < destinationIndex + pickedNumbers; i++) {
            numbers.add(i + 1, pickedUpNumbers.pop());
        }

        numbers.add(currentNumber);

    }

    private int findMin() {
        return numbers.stream().min(Integer::compare).orElseThrow(() -> new RuntimeException("No numbers provided"));
    }

    private int findMax() {
        return numbers.stream().max(Integer::compare).orElseThrow(() -> new RuntimeException("No numbers provided"));
    }

}
