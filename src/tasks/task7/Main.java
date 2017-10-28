package tasks.task7;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String path = "D:\\Study\\Jura\\Java2k17\\src\\tasks\\task7\\test.txt";
        int n = 30;
        //String path = args[0];
        //int n = Integer.parseInt(args[1]);
        long assumedSize = 80;

        File file = new File(path);
        long length = file.length();
        int amountOfLines = (int)(length / assumedSize);
        System.out.println(amountOfLines);
        List<String> list = new ArrayList<String>(2 * amountOfLines);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            for (int i = 0; i < amountOfLines; i++) {
                list.add(br.readLine());
            }
        } catch (IOException e) {
            System.out.println("IOException");
        }
        System.out.println(list.size());
        for (int i = 0; i < n; i++) {
            int index = (int)(Math.random() * amountOfLines);
            System.out.println(list.get(index));
        }
    }
}
