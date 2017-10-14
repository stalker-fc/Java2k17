package tasks.task6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main {
    public static int countLetters(String line, char letter) {
        int count = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == letter) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String path = "D:\\Study\\Jura\\Java2k17\\src\\tasks\\task6\\test.txt";
        char symbol = 'e';
        //String path = args[0];
        //char symbol = args[1].charAt(0);

        try (Stream<String> lines = Files.lines(Paths.get(path))) {
            System.out.println(lines.mapToInt(line -> countLetters(line, symbol)).sum());
        } catch (IOException e) {
            System.out.println("IO Exception");
        }
    }
}
