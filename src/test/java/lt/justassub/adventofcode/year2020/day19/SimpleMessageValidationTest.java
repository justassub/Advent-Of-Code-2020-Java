package lt.justassub.adventofcode.year2020.day19;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class SimpleMessageValidationTest {
    SimpleMessageValidator simpleMessage = new SimpleMessageValidator(1L, "a");

    @Test
    public void validateSimpleCaseOneLetter() throws NotValidException {
        Assert.assertEquals("",simpleMessage.validate("a"));
    }
    @Test
    public void validateSimpleCaseTwoLettersr() throws NotValidException {
        Assert.assertEquals("bc",simpleMessage.validate("abc"));
    }
    @Test
    public void validateDifficultCase() throws NotValidException {
        SimpleMessageValidator simpleMessage = new SimpleMessageValidator(1L, "b");
        Assert.assertEquals("cbcb",simpleMessage.validate("abcbcb"));
    }
    @Test
    public void validateNoString()  {
         assertThrows(NotValidException.class, () -> simpleMessage.validate(""));
    }
}
