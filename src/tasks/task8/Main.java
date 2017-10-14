package tasks.task8;

import java.util.stream.Stream;

public class Main {
    public static long getValue(long xn) {
        long a = 25214903917L;
        long c = 11L;
        long m = (long)Math.pow(2, 48);

        return (a * xn + c) % m;
    }
    public static void main(String[] args) {
        Stream<Long> stream = Stream.iterate(123L, Main::getValue);
    }
}
