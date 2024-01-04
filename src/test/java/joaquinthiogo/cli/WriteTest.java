package joaquinthiogo.cli;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class WriteTest {
    @Test
    void create() throws IOException {
        Path path = Path.of("text.txt");
        try (Writer writer = Files.newBufferedWriter(path, StandardOpenOption.APPEND)) {
            for (int i = 0; i < 10; i++) {
                writer.write("Hello world\n");
            }
        }
    }

    @Test
    Integer lastLine() throws IOException {
        Path path = Path.of("text.txt");

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            int lastLine = 0;
            while (reader.readLine() != null) {
                lastLine++;
            }
            return lastLine;
        }
    }


}
