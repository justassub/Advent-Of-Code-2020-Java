package lt.justassub.adventofcode.year2020.day21;

import lt.justassub.adventofcode.year2020.Main2020;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Day21 extends Main2020<List<String>, List<String>, Long, String> {
    Map<String, String> answer = new TreeMap<>();

    @Override
    protected Long part1(List<String> info) {
        List<Food> foods = info.stream()
                .map(line -> {
                    int splitIndex = line.indexOf(" (");
                    String allergenText = line.substring(splitIndex + ", (contains".length(), line.length() - 1);
                    String foodText = line.substring(0, splitIndex);
                    return new Food(
                            createFoods(foodText),
                            createAllergens(allergenText));

                }).collect(toList());

        Set<String> allergens = foods.stream()
                .flatMap(f -> f.allergens().stream())
                .collect(Collectors.toUnmodifiableSet());
        Set<String> allIngridient = foods.stream()
                .flatMap(f -> f.ingr().stream())
                .collect(Collectors.toUnmodifiableSet());

        Map<String, List<List<String>>> possibleCombinations = new TreeMap<>();

        for (String allergen : allergens) {
            List<List<String>> products = new ArrayList<>();
            for (Food f : foods) {
                if (f.allergens().contains(allergen)) {
                    products.add(f.ingr());
                }
            }
            possibleCombinations.put(allergen, products);
        }

        while (answer.size() != allergens.size()) {
            for (Map.Entry<String, List<List<String>>> v : possibleCombinations.entrySet()) {
                if (answer.containsKey(v.getKey())) {
                    continue;
                }
                List<String> impossibleToHave = new ArrayList<>(); // NO NEEDED, but I wanted then to take those values and remove from possible Combinations
                List<String> possibilieties = new ArrayList<>();
                Set<String> products = v.getValue().stream()
                        .flatMap(Collection::stream)
                        .collect(toSet());

                for (String product : products) {
                    boolean allMatch = v.getValue().stream()
                            .allMatch(s -> s.contains(product));
                    if (!allMatch) {
                        impossibleToHave.add(product);
                    }
                    if (answer.containsValue(product)) {
                        impossibleToHave.add(product);
                    }
                    if (allMatch && !answer.containsValue(product)) {
                        possibilieties.add(product);
                    }
                }
                if (possibilieties.size() == 1) {
                    answer.put(v.getKey(), possibilieties.get(0));
                }
            }
        }
        Map<String, Long> countNumberOfFoods = foods.stream()
                .flatMap(f -> f.ingr().stream())
                .collect(groupingBy(s -> s, counting()));

        return allIngridient.stream()
                .filter(i -> !answer.containsValue(i))
                .mapToLong(countNumberOfFoods::get)
                .sum();
    }


    @Override
    protected String part2(List<String> input) {
        part1(input);
        return String.join(",", answer.values());
    }

    public static void main(String[] args) {
        Day21 day21 = new Day21();
        List<String> foods = day21.getFileContent().collect(toList());
        System.out.println("Part 1 answer: " + day21.part1(foods));
        System.out.println(day21.part2(foods));
    }

    private static List<String> createAllergens(String allergens) {
        return Stream.of(allergens.split(", ")).collect(toList());
    }

    private static List<String> createFoods(String foods) {
        return Stream.of(foods.split(" ")).collect(toList());
    }
}
