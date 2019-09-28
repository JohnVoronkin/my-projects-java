package lists.stream;

import lists.stream.ExampleClass.Bar;
import lists.stream.ExampleClass.Foo;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class SimpleFlatMapStream {

  public static void main(String[] args) {

    ArrayList<Foo> foos = new ArrayList<>();

    // create foos
    IntStream.range(1, 4)
            .forEach(i -> foos.add(new Foo("Foo " + i)));

    // create bars
    foos.forEach(f -> IntStream
            .range(1, 4)
            .forEach(i -> f.getBars().add(new Bar("Bar " + i + " <- " + f.getName())))
    );

    foos.stream()
            .flatMap(foo -> foo.getBars().stream())
            .forEach(b -> System.out.println(b.getName()));

  }

}
