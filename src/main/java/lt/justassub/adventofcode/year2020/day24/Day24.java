package lt.justassub.adventofcode.year2020.day24;

import lombok.extern.log4j.Log4j2;
import lt.justassub.adventofcode.year2020.Main2020;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.Predicate.not;
import static java.util.function.UnaryOperator.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.toSet;

@Log4j2
public class Day24 extends Main2020<List<String>, List<String>, Integer, Integer> {
    @Override
    protected Integer part1(List<String> input) {

        return getActiveLayouts(input).size();
    }

    @Override
    protected Integer part2(List<String> input) {
        Set<Layout> layouts = getActiveLayouts(input);

        for (int day = 0; day < 100; day++) {
            layouts = Stream.concat(
                    getLayoutsForBlack(layouts),
                    getLayoutsForWhite(layouts)
            ).collect(Collectors.toSet());

            log.trace(" day {}: {}", day + 1, layouts.size());
        }
        return layouts.size();
    }

    private Stream<Layout> getLayoutsForBlack(Set<Layout> actives) {
        return actives.stream()
                .filter(l -> {
                    long size = l.getAdjancedLayouts().stream().filter(actives::contains).count();
                    return size == 1 || size == 2;
                });

    }

    private Stream<Layout> getLayoutsForWhite(Set<Layout> actives) {
        return actives.stream()
                .flatMap(a -> a.getAdjancedLayouts().stream())
                .filter(not(actives::contains))
                .filter(notActives -> notActives.getAdjancedLayouts().stream()
                                              .filter(actives::contains).count() == 2
                );
    }

    private Set<Layout> getActiveLayouts(List<String> input) {
        return input.stream()
                .map(LayoutFactory::buildLayout)
                .collect(Collectors.groupingBy(identity(), counting())).entrySet().stream()
                .filter(n -> n.getValue() % 2 != 0)
                .map(Map.Entry::getKey)
                .collect(toSet());
    }

    public static void main(String[] args) {
        Day24 day24 = new Day24();
        List<String> content = day24.getFileContent().collect(Collectors.toList());
        System.out.println(day24.part1(content));
        System.out.println(day24.part2(content));
    }
}
