package JavaIO;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

//2.     Прочитать текст Java-программы и все слова public в объявлении
// атрибутов и методов класса заменить на слово private.
public class OptionalTask2 {

    public static void main(String[] args) {
        List<String> lines = new ArrayList<>();
        Path path = Paths.get("data/Example.txt");
        Charset charset = StandardCharsets.UTF_8;

        try (BufferedReader reader = Files.newBufferedReader(path, charset)) {

            String line;
            while ((line = reader.readLine()) != null)
                lines.add(line);

        } catch (IOException ignored) {
        }
        System.out.println(lines);
        List<String> refactoredLines = new ArrayList<>();
        for (String line : lines) {
            refactoredLines.add(line.replace("public", "private"));

        }
        System.out.println(refactoredLines);

        try (FileWriter writer = new FileWriter("data/RefactoredExample.txt", false)) {
            for (String line : refactoredLines) {
                writer.write(line);
                writer.write(System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
