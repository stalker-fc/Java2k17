package tasks.task5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static boolean containsWord(Path pathToFile, String word) {
        try (Stream<String> lines = Files.lines(pathToFile)) {
            return lines.anyMatch(line -> line.contains(word));
        } catch (IOException e) {
            return false;
        }
    }

    public static List<String> getFileNames(String directory) throws IOException {
        List<String> files = new ArrayList<String>();
        Files.walk(Paths.get(directory))
                .filter(path -> containsWord(path, "volatile"))
                .filter(path -> containsWord(path, "transient"))
                .forEach(System.out::println);
        return files;
    }

    public static void main(String[] args) {
        String directory = "D:/Study/Jura/src";
        try {
            getFileNames(directory).forEach(System.out::println);
        }catch(IOException e){
            System.out.println("IO exception");
        }
    }
}
