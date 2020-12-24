package lt.justassub.adventofcode.year2020.day23;

import lombok.Getter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.IntStream;

public class CupGame {
    private final int movesToPlay;
    @Getter
    private LinkedList<Integer> numbers;
    @Getter
    private final Map<Integer, Integer> links = new HashMap<>();

    private final int minNumber;
    private final int maxNumber;

    private final int pickedNumbers = 3;

    public CupGame(int movesToPlay, LinkedList<Integer> integers) {
        this.movesToPlay = movesToPlay;
        this.numbers = new LinkedList<>(integers);
        minNumber = findMin();
        maxNumber = findMax();
        int numberOne = numbers.pop();
        int numberTwo = numbers.pop();
        while (true) {
            try {
                links.put(numberOne, numberTwo);
                numberOne = numberTwo;
                numberTwo = numbers.removeFirst();
            } catch (Exception e) {
                break;
            }
        }

        links.put(integers.peekLast(), integers.peekFirst());
        if (links.size() != 1_000_000) {
            throw new RuntimeException("Size was: " + links.size());
        }
        this.numbers = new LinkedList<>(integers);
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

    public void playWithBigData() {
        int currentCup = numbers.peekLast();
        for (int i = 0; i < movesToPlay; i++) {
            currentCup = links.get(currentCup);

            LinkedList<Integer> pickedUpNumbers = new LinkedList<>();
            int nextCup = currentCup;

            for (int z = 0; z < pickedNumbers; z++) {
                nextCup = links.get(nextCup);
                pickedUpNumbers.add(nextCup);
            }
            links.put(currentCup, links.get(nextCup));
            int destination = currentCup - 1;

            while (pickedUpNumbers.contains(destination) || destination < 1) {
                --destination;
                if (destination < 1) {
                    destination = maxNumber;
                }
            }
            int tmpNumber = links.get(destination);
            links.put(destination, pickedUpNumbers.peekFirst());
            links.put(pickedUpNumbers.peekLast(), tmpNumber);
        }

    }

    private int findMin() {
        return numbers.stream().min(Integer::compare).orElseThrow(() -> new RuntimeException("No numbers provided"));
    }

    private int findMax() {
        return numbers.stream().max(Integer::compare).orElseThrow(() -> new RuntimeException("No numbers provided"));
    }

}
