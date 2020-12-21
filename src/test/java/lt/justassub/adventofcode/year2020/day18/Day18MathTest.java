package lt.justassub.adventofcode.year2020.day18;

import org.junit.Assert;
import org.junit.Test;

public class Day18MathTest {
    @Test
    public void doSimpleAddAction() {
        String line = "6 + 8";
        assertAnswerParentheses(14, line);
    }

    @Test
    public void doMultiplicationAddAction() {
        String line = "2 * 8";
        assertAnswerParentheses(16, line);
    }

    @Test
    public void doMultipleActionsAction1() {
        String line = "2 * 8 * 5";
        assertAnswerParentheses(80, line);
    }

    @Test
    public void doMultipleActionsAction2() {
        String line = "2 * 8 + 5";
        assertAnswerParentheses(21, line);
    }

    @Test
    public void doMultipleActionsPriority1() {
        String line = "1 + 2 * 3 + 4 * 5 + 6";
        assertAnswerParentheses(231, line, "+");
    }

    @Test
    public void doMultipleActionsPriority2() {
        String line = "1 + (2 * 3) + (4 * (5 + 6))";
        assertAnswerParentheses(51, line, "+");
    }

    @Test
    public void doMultipleActionsPriority3() {
        String line = "2 * 3 + (4 * 5)";
        assertAnswerParentheses(46, line, "+");
    }

    @Test
    public void doSimpleParentheses1() {
        String line = "(2 * 8 + 5)";
        assertAnswerParentheses(21, line);
    }

    @Test
    public void doSimpleParentheses2() {
        String line = "((2 + 8) * 5)";
        assertAnswerParentheses(50, line);
    }

    @Test
    public void doSimpleParentheses3() {
        String line = "(2 + (8 * 5))";
        assertAnswerParentheses(42, line);
    }

    @Test
    public void doSimpleParentheses4() {
        String line = "2 * 3 + (4 * 5)";
        assertAnswerParentheses(26, line);
    }

    @Test
    public void doSimpleParentheses5() {
        String line = "5 + (8 * 3 + 9 + 3 * 4 * 3)";
        assertAnswerParentheses(437, line);
    }

    @Test
    public void doSimpleParentheses6() {
        String line = "5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))";
        assertAnswerParentheses(12240, line);
    }

    @Test
    public void doSimpleParentheses7() {
        String line = "((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2";
        assertAnswerParentheses(13632, line);
    }


    private void assertAnswerParentheses(long assertAnswer, String line) {
        assertAnswerParentheses(assertAnswer, line, null);
    }

    private void assertAnswerParentheses(long assertAnswer, String line, String priority) {
        Assert.assertEquals(assertAnswer, Day18Util.calculateLineWithParentheses(line, priority));
    }

}
