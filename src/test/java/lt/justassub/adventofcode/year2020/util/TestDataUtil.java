package lt.justassub.adventofcode.year2020.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static java.lang.String.format;

public class TestDataUtil {
    public static Stream<String> getFileContent(String fileName) {
        try {
            return Files.lines(Paths.get(format("src/test/resources/2020/%s.txt", fileName)));
        } catch (IOException e) {
            throw new RuntimeException("File was not found", e);
        }
    }
}
