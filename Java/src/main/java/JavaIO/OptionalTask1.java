package JavaIO;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class OptionalTask1 {
    public static void main(String[] args) {
        //1.     Создать и заполнить файл случайными целыми числами. Отсортировать содержимое файла
        // по возрастанию.
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите количество случайных чисел:");
        int quantity = scan.nextInt();
        int[] array = new int[quantity];
        scan.close();
        final Random random = new Random();
        for (int i = 0; i < array.length; ++i)
            array[i] = random.nextInt(10);

        try (FileWriter writer = new FileWriter("data/random.txt", false)) {
            for (int j : array) {
                final String numbers = Integer.toString(j);
                writer.write(numbers);
                writer.write(System.lineSeparator());
                System.out.println(numbers);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        List<String> lines = new ArrayList<>();
        Path path = Paths.get("data/random.txt");
        Charset charset = StandardCharsets.UTF_8;

        try (BufferedReader reader = Files.newBufferedReader(path, charset)) {

            String line;
            while ((line = reader.readLine()) != null)
                lines.add(line);

        } catch (IOException ignored) {
        }

        System.out.println(lines);
        Collections.sort(lines);
        System.out.println(lines);
        try (FileWriter writer = new FileWriter("data/sorted.txt", false)) {
            for (String line : lines) {
                writer.write(line);
                writer.write(System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}