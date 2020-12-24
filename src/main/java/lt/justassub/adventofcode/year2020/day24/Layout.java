package lt.justassub.adventofcode.year2020.day24;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static lt.justassub.adventofcode.year2020.day24.Constants.DIRECTIONS;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
public class Layout {
    private int x;
    private int y;

    public void addToX(int value) {
        this.x += value;
    }

    public void addToY(int value) {
        this.y += value;
    }

    public List<Layout> getAdjancedLayouts() {
        return DIRECTIONS.stream()
                .map(d -> d.getNewLayoutIntoThatDirection(this))
                .collect(toList());
    }

}
