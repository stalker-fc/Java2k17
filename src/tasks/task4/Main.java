package tasks.task4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static Stream<String> getWordsStream(Scanner scanner) {
        return Stream.generate(scanner::nextLine)
                .map(line -> line.split("\\s"))
                .flatMap(Arrays::stream);
    }

    public static IntStream getIntStream(Scanner scanner) {
        return IntStream.generate(scanner::nextInt);
    }

    public static DoubleStream getDoubleStream(Scanner scanner) {
        return DoubleStream.generate(scanner::nextDouble);
    }

    public static Stream<String> getLineStream(Scanner scanner) {
        return Stream.generate(scanner::nextLine);
    }

    public static void main(String[] args) {
        String path = "D:\\Study\\Jura\\Java2k17\\src\\tasks\\task4\\test.txt";
        File file = new File(path);
        try {
            Scanner scanner = new Scanner(file);

            //IntStream stream = getIntStream(scanner);
            //DoubleStream stream = getDoubleStream(scanner);
            Stream<String> stream = getLineStream(scanner);
            //Stream<String> stream = getWordsStream(scanner);

            stream.limit(5).forEach(System.out::println);

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }


    }
}
