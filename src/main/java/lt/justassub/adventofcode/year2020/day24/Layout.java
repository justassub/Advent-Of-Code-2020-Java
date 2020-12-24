package lt.justassub.adventofcode.year2020.day24;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
public class Layout {
    private int x = 0;
    private int y = 0;

    public void addToX(int value) {
        this.x += value;
    }

    public void addToY(int value) {
        this.y += value;
    }

}
