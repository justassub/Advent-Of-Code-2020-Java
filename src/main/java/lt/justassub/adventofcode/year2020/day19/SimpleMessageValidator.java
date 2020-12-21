package lt.justassub.adventofcode.year2020.day19;

import java.util.List;

public class SimpleMessageValidator implements MessageValidator {
    private Long id;
    private String value;


    public SimpleMessageValidator(Long id, String value) {
        this.id = id;
        this.value = value;
    }

    @Override
    public String validate(String message) throws NotValidException {
        if (message == null) {
            return null;
        }
        int valueIndex = message.indexOf(value);
        if (valueIndex == -1) {
            throw new NotValidException(message + " is not valid :(");
        }
        return message.substring(valueIndex + 1);

    }

    @Override
    public void setMatchAny(List<List<MessageValidator>> validators) {
        throw new RuntimeException("Unsupported");
    }
}
