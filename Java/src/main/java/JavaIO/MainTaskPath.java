package JavaIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
//E:/Music/Haggard
//data\info2.txt

public class MainTaskPath {
    public static void main(String[] args) {
        try (FileWriter writer = new FileWriter("data/info2.txt", true)) {

            File directory = new File(args[0]);
            System.out.println(directory);
            if (directory.isDirectory()) {
                for (File item : directory.listFiles()) {
                    if (item.isDirectory()) {

                        System.out.println(item.getName() + "  \t folder");
                        writer.write(item.getName() + "\n");

                        for (File item2 : item.listFiles()) {
                            System.out.println("  \t" + item2.getName() + " \t file");
                            writer.write(("\t" + item2.getName() + "\n"));
                        }
                    }
                }

            }else {
                List<String> lines = new ArrayList<>();
                Path path = Paths.get("data/info2.txt");
                Charset charset = StandardCharsets.UTF_8;

                try (BufferedReader reader = Files.newBufferedReader(path, charset)) {

                    String line;
                    while ((line = reader.readLine()) != null)
                        lines.add(line);

                } catch (IOException ignored) {
                }

                List<String> literals = new ArrayList<>();
                int files = 0;
                int folders = 0;
                for (String line : lines) {
                    if (line.contains(".mp3")) {
                        files++;
                        literals.add(line.replace(".mp3", ""));
                    } else folders++;
                }
                int literalsQuantity = 0;
                for (String literal : literals) {
                    literalsQuantity += literal.length();
                }
                int averageLiteralsQuantity = literalsQuantity / literals.size();

                System.out.println("Folders = " + folders);
                System.out.println("Files = " + files);
                System.out.println("Average quantity of files in folders: " + files / folders);
                System.out.println("Average quantity of literals in file names: " + averageLiteralsQuantity);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}