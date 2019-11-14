package collections.streams;

import person.Person;

import java.util.Arrays;
import java.util.List;

public class SimpleReduceStream {

  public static void main(String[] args) {

    List<Person> persons = Arrays.asList(
            new Person("Andrey", 20),
            new Person("Igor", 19),
            new Person("Ira", 41),
            new Person("Jon", 23),
            new Person("John", 56),
            new Person("Vitia", 12)
    );

    persons.stream()
            .reduce((p1, p2) -> p1.getAge() > p2.getAge() ? p1 : p2)
            .ifPresent(System.out::println);

  }



}
