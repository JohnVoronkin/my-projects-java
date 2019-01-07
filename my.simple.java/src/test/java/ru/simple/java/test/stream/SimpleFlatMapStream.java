package ru.simple.java.test.stream;

import ru.simple.java.test.stream.ExampleClass.Bar;
import ru.simple.java.test.stream.ExampleClass.Foo;

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
