package tasks.task7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        String path = args[0];
        int n = Integer.parseInt(args[1]);
        long length = 0;
        File file = new File(path);

        try (Stream<String> lines = Files.lines(Paths.get(path))) {
            length = lines.count();

        } catch (IOException e) {
            System.out.println("IOException");
        }


    }
}
