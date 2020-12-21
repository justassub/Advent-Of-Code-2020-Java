package lt.justassub.adventofcode.year2020.day19;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;

import static java.util.Arrays.asList;

public class RuleWithInnerRulesValidationTest {
    @Test
    public void simpleCase() throws NotValidException {
        MessageValidator messageValidator = new MessageWithOtherRules(0L);
        MessageValidator simpleMessageValidator1 = new SimpleMessageValidator(4L, "a");
        MessageValidator simpleMessageValidator2 = new SimpleMessageValidator(5L, "b");
        messageValidator.setMatchAny(asList(asList(simpleMessageValidator1, simpleMessageValidator2)));
        Assert.assertNotNull(messageValidator.validate("ababbb"));
    }

    @Test
    public void MoreDifficultCase() throws NotValidException {
        MessageValidator messageValidator = new MessageWithOtherRules(0L);
        MessageValidator simpleMessageValidator1 = new SimpleMessageValidator(4L, "a");
        MessageValidator simpleMessageValidator2 = new SimpleMessageValidator(5L, "b");
        MessageValidator messageValidatorInner = new MessageWithOtherRules(1L);
        messageValidatorInner.setMatchAny(asList(asList(simpleMessageValidator1, simpleMessageValidator2)));
        messageValidator.setMatchAny(asList(Collections.singletonList(messageValidatorInner)));
        Assert.assertNotNull(messageValidator.validate("ababbb"));
    }

    @Test
    public void simpleCaseExample() throws NotValidException {
        MessageValidator messageValidator = new MessageWithOtherRules(0L);
        MessageValidator simpleMessageValidator1 = new SimpleMessageValidator(1L, "a");
        Assert.assertEquals("b",simpleMessageValidator1.validate("ab"));
        MessageValidator simpleMessageValidator2 = new SimpleMessageValidator(2L, "b");
        Assert.assertEquals("",simpleMessageValidator2.validate("ab"));
        MessageValidator messageValidatorInner = new MessageWithOtherRules(3L);
        messageValidatorInner.setMatchAny(asList(asList(simpleMessageValidator1, simpleMessageValidator2),asList(simpleMessageValidator2, simpleMessageValidator1)));
        Assert.assertEquals("", messageValidatorInner.validate("ab"));
        Assert.assertEquals("", messageValidatorInner.validate("ba"));

        messageValidator.setMatchAny(Collections.singletonList(asList(simpleMessageValidator1, messageValidatorInner)));

        Assert.assertEquals("", messageValidator.validate("aab"));
        Assert.assertEquals("", messageValidator.validate("aba"));

    }

    @Test
    public void example1() throws NotValidException {
        MessageValidator messageValidator = new MessageWithOtherRules(0L);
        MessageValidator simpleMessageValidatorA = new SimpleMessageValidator(4L, "a");
        MessageValidator simpleMessageValidatorB = new SimpleMessageValidator(5L, "b");

        MessageValidator messageValidatorInner3 = new MessageWithOtherRules(3L);
        messageValidatorInner3.setMatchAny(asList(asList(simpleMessageValidatorA, simpleMessageValidatorB), asList(simpleMessageValidatorB, simpleMessageValidatorA)));

        MessageValidator messageValidatorInner2 = new MessageWithOtherRules(2L);
        messageValidatorInner2.setMatchAny(asList(asList(simpleMessageValidatorA, simpleMessageValidatorA), asList(simpleMessageValidatorB, simpleMessageValidatorB)));

        MessageValidator messageValidatorInner1 = new MessageWithOtherRules(1L);
        messageValidatorInner1.setMatchAny(asList(asList(messageValidatorInner2, messageValidatorInner3), asList(messageValidatorInner3, messageValidatorInner2)));
        Assert.assertNotNull(messageValidatorInner1.validate("bbbab"));
        messageValidator.setMatchAny(asList(asList(simpleMessageValidatorA, messageValidatorInner1, simpleMessageValidatorB)));
        Assert.assertNotNull(messageValidator.validate("ababbb"));

        Assert.assertNotNull(messageValidator.validate("abbbab"));

    }

    @Test
    public void example2() throws NotValidException {
        MessageValidator messageValidator = new MessageWithOtherRules(0L);
        MessageValidator simpleMessageValidatorA = new SimpleMessageValidator(4L, "a");
        MessageValidator simpleMessageValidatorB = new SimpleMessageValidator(5L, "b");

        MessageValidator messageValidatorInner3 = new MessageWithOtherRules(3L);
        messageValidatorInner3.setMatchAny(asList(asList(simpleMessageValidatorA, simpleMessageValidatorB), asList(simpleMessageValidatorB, simpleMessageValidatorA)));

        MessageValidator messageValidatorInner2 = new MessageWithOtherRules(2L);
        messageValidatorInner2.setMatchAny(asList(asList(simpleMessageValidatorA, simpleMessageValidatorA), asList(simpleMessageValidatorB, simpleMessageValidatorB)));

        MessageValidator messageValidatorInner1 = new MessageWithOtherRules(1L);
        messageValidatorInner1.setMatchAny(asList(asList(messageValidatorInner2, messageValidatorInner3), asList(messageValidatorInner3, messageValidatorInner2)));
        messageValidator.setMatchAny(Collections.singletonList(asList(simpleMessageValidatorA, messageValidatorInner1, simpleMessageValidatorB)));
        Assert.assertEquals("",messageValidator.validate("aaaabb"));
        Assert.assertNull(messageValidator.validate("bababa"));
        Assert.assertNull(messageValidator.validate("aaabbb"));



    }
}
