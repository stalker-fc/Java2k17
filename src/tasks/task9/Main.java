package tasks.task9;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Main {

    public static <T> Stream<T> zip(Stream<T> a, Stream<T> b) {
        Spliterator<T> aSpliterator = a.spliterator();
        Spliterator<T> bSpliterator = b.spliterator();

        Iterator<T> aIterator = Spliterators.iterator(aSpliterator);
        Iterator<T> bIterator = Spliterators.iterator(bSpliterator);
        Iterator<T> cIterator = new Iterator<T>() {
            boolean timeOfA = true;
            @Override
            public boolean hasNext() {
                return aIterator.hasNext() && bIterator.hasNext() || (!timeOfA && bIterator.hasNext());
            }

            @Override
            public T next() {
                if (timeOfA) {
                    timeOfA = false;
                    return aIterator.next();
                }
                timeOfA = true;
                return bIterator.next();
            }
        };
        int characteristics = aSpliterator.characteristics() & bSpliterator.characteristics() &
                ~(Spliterator.DISTINCT | Spliterator.SORTED | Spliterator.SIZED);

        Spliterator<T> split = Spliterators.spliteratorUnknownSize(cIterator, characteristics);
        return (a.isParallel() || b.isParallel())
                ? StreamSupport.stream(split, true)
                : StreamSupport.stream(split, false);
    }


    public static void main(String[] args) {
        String[] a = {"a", "b", "c", "d", "s"};
        String[] b = {"e", "f", "g", "h"};

        System.out.println(zip(Arrays.stream(a), Arrays.stream(b))
                .collect(Collectors.joining(", ")));
    }
}
