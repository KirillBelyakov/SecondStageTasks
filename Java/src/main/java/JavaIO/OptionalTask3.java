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

//  9.  Из текста Java-программы удалить все виды комментариев.
public class OptionalTask3 {

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
        List<String> noCommentsLines = new ArrayList<>();
        for (String line : lines) {
            if (!line.contains("//")) {
                noCommentsLines.add(line);
            }
        }
        System.out.println(noCommentsLines);

        try (FileWriter writer = new FileWriter("data/ExampleWithNoComments.txt", false)) {
            for (String line : noCommentsLines) {
                writer.write(line);
                writer.write(System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}


