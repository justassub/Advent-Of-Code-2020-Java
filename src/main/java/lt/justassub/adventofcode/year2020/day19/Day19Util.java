package lt.justassub.adventofcode.year2020.day19;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class Day19Util {

    public static Map<Long, MessageValidator> fillRulesWithInformation(String input) {
        Map<Long, MessageValidator> validators = new HashMap<>();
        Map<Long, String> values = Stream.of(input.split("\n"))
                .map(l -> l.split(": "))
                .map(a -> Map.entry(Long.parseLong(a[0]), a[1]))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue));
        values.entrySet().stream()
                .filter(v -> !v.getValue().matches(".*\\d.*"))
                .forEach(v -> validators.put(v.getKey(), new SimpleMessageValidator(v.getKey(), v.getValue().replace("\"", ""))));
        values.entrySet().stream()
                .filter(v -> v.getValue().matches(".*\\d.*"))
                .forEach(v -> validators.put(v.getKey(), new MessageWithOtherRules(v.getKey())));
        values.entrySet().stream()
                .filter(v -> v.getValue().matches(".*\\d.*"))
                .forEach(v -> {
                    List<List<MessageValidator>> valid = new ArrayList<>();
                    Long id = v.getKey();
                    for (String rules : v.getValue().split(" \\| ")) {
                        List<MessageValidator> ids = new ArrayList<>();

                        for (String ruleId : rules.split(" ")) {
                            Long idLong = Long.parseLong(ruleId);
                            ids.add(validators.get(idLong));
                        }
                        valid.add(ids);
                    }
                    validators.get(id).setMatchAny(valid);


                });
        return validators;
    }
}
