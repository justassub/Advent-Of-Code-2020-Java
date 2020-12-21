package lt.justassub.adventofcode.year2020.day12;

import org.junit.Assert;
import org.junit.Test;

import static lt.justassub.adventofcode.year2020.day12.Directory.*;

public class DirectoryChangeTest {
    @Test
    public void noChangesShouldReturnSameDirectory1() {
        Assert.assertEquals(E, E.addChangingDirectoryAndReturnNewDirectory(0));
    }

    @Test
    public void noChangesShouldReturnSameDirectory2() {
        Assert.assertEquals(W, W.addChangingDirectoryAndReturnNewDirectory(0));
    }

    @Test
    public void changesToLeftShouldReturnCorrectDirectory1() {
        Assert.assertEquals(S, E.addChangingDirectoryAndReturnNewDirectory(90));
    }

    @Test
    public void changesToLeftShouldReturnCorrectDirectory2() {
        Assert.assertEquals(N, E.addChangingDirectoryAndReturnNewDirectory(-90));
    }

    @Test
    public void changesToLeftShouldReturnCorrectDirectory3() {
        Assert.assertEquals(S, E.addChangingDirectoryAndReturnNewDirectory(-270));
    }

    @Test
    public void changesToLeftShouldReturnCorrectDirectory4() {
        Assert.assertEquals(W, N.addChangingDirectoryAndReturnNewDirectory(-90));
    }

    @Test
    public void changesToLeftShouldReturnCorrectDirectory5() {
        Assert.assertEquals(E, N.addChangingDirectoryAndReturnNewDirectory(90));
    }

    @Test
    public void changesToLeftShouldReturnCorrectDirectory6() {
        Assert.assertEquals(S, N.addChangingDirectoryAndReturnNewDirectory(180));
    }

    @Test
    public void changesToLeftShouldReturnCorrectDirectory7() {
        Assert.assertEquals(N, N.addChangingDirectoryAndReturnNewDirectory(0));
    }
    @Test
    public void changesToLeftShouldReturnCorrectDirectory8() {
        Assert.assertEquals(W, W.addChangingDirectoryAndReturnNewDirectory(720));
    }

    @Test
    public void changesToLeftShouldReturnCorrectDirectory10() {
        Assert.assertEquals(W, W.addChangingDirectoryAndReturnNewDirectory(-360));
    }

}
