package lt.justassub.adventofcode.year2020.day19;

import java.util.List;

public class MessageWithOtherRules implements MessageValidator {
    private Long id;
    private List<List<MessageValidator>> matchAny;

    public MessageWithOtherRules(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setMatchAny(List<List<MessageValidator>> matchAny) {
        this.matchAny = matchAny;
    }

    @Override
    public String validate(String message) {
        String answer = null;

        for (List<MessageValidator> messageValidators : matchAny) {
            try {
                String answer1 = message;

                for (MessageValidator messageValidator : messageValidators) {
                    answer1 = messageValidator.validate(answer1);
                }
                if (answer == null && answer1 != null) {
                    answer = answer1;
                } else if (answer1 != null && answer1.length() > answer.length()) {
                    answer = answer1;
                }
            } catch (NotValidException e) {
                //ignore

            }

        }

        return answer;
    }
}
