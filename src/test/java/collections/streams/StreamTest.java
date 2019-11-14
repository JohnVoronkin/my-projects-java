package collections.streams;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

  public static void main(String[] args) {

    // Примитивный поток
    IntStream.range(1, 10).forEach(System.out::println);

    Stream.of("a1", "a2", "a3")
            .findFirst()
            .ifPresent(System.out::println);

    // Преобразование потоков: Поток объектов -> Примитивный поток
    Stream.of("a1", "a2", "a3")
            .map(s -> s.substring(1))
            .mapToInt(Integer::parseInt)
            .max()
            .ifPresent(System.out::println);

    // Преобразование потоков:  Примитивный поток -> Поток объектов
    IntStream.range(1, 4)
            .mapToObj(i -> "c" + i)
            .forEach(System.out::print);
    System.out.println();
    Stream.of(1.0, 2.0, 3.0)
            .mapToInt(Double::intValue)
            .mapToObj(i -> "c" + i)
            .forEach(System.out::print);

  }
}
