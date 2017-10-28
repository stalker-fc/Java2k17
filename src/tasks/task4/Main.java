package tasks.task4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static Stream<String> getWordsStream(Scanner scanner) {
        return Stream.generate(()-> {
            if (scanner.hasNextLine())
                return scanner.nextLine();
            else
                return null;
        }).filter(line -> line.equals(""))
                .map(line -> line.split("\\s"))
                .flatMap(Arrays::stream);
    }

    public static Stream<Integer> getIntStream(Scanner scanner) {
        return Stream.generate(() -> {
            if (scanner.hasNextInt())
                return scanner.nextInt();
            else
                return null;
        }).filter(Objects::nonNull);
    }

    public static Stream<Double> getDoubleStream(Scanner scanner) {
        return Stream.generate(() -> {
            if (scanner.hasNextDouble())
                return scanner.nextDouble();
            else
                return null;
        }).filter(Objects::nonNull);
    }

    public static Stream<String> getLineStream(Scanner scanner) {
        return Stream.generate(()-> {
            if (scanner.hasNextLine())
                return scanner.nextLine();
            else
                return null;
        }).filter(Objects::nonNull);
    }

    public static void main(String[] args) {
        String path = "D:\\Study\\Jura\\Java2k17\\src\\tasks\\task4\\test.txt";
        File file = new File(path);
        try {
            Scanner scanner = new Scanner(file);

            //Stream<Integer> stream = getIntStream(scanner);
            Stream<Double> stream = getDoubleStream(scanner);
            //Stream<String> stream = getLineStream(scanner);
            //Stream<String> stream = getWordsStream(scanner);

            stream.limit(10).forEach(System.out::println);

        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }


    }
}
