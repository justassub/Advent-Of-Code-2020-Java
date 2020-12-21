package lt.justassub.adventofcode.year2020;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.String.format;

public abstract class MainJava<I1, I2, O1, O2> {

    protected abstract String getPackage();

    protected final String getFileName() {
        return this.getClass().getSimpleName().toLowerCase();
    }

    protected final Stream<String> getFileContent() {
        try {
            return Files.lines(Paths.get(format("src/main/resources/%s/%s.txt", getPackage(), getFileName())));
        } catch (IOException e) {
            throw new RuntimeException("File was not found", e);
        }
    }

    protected final List<String> getFileContentSplited(String spliterator) {
        try {
            return Arrays.asList(new String(Files.readAllBytes(getPath()))
                    .split(spliterator));

        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    private final Path getPath() {
        return Paths.get(format("src/main/resources/%s/%s.txt", getPackage(), getFileName()));
    }

    protected abstract O1 part1(I1 input);

    protected abstract O2 part2(I2 input);
}
