package ru.simple.java.test.stream;

import person.Person;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SimpleStream {

  public static void main(String[] args) {

    List<Person> persons = Arrays.asList(
            new Person("Andrey", 20),
            new Person("Igor", 23),
            new Person("Ira", 23),
            new Person("Vitia", 12)
    );

    /* Collect - превращает элементы потока в List, Set или Map
     1. фильтруем список объектов класса Person (по заданному фильтру)
      */
    List<Person> filtered = persons.stream()
            .filter(person -> person.getName().startsWith("I"))
            .collect(Collectors.toList());

    System.out.println(filtered);

    System.out.println();

    // 1.1 сгруппируем людей по возрасту
    Map<Integer, List<Person>> personsByAge = persons.stream()
            .collect(Collectors.groupingBy(Person::getAge));

    personsByAge.forEach((age, p) -> System.out.format("age %s: %s\n", age, p));

    System.out.println();

    // 1.2 вывести средний возраст людей
    Double avg = persons.stream()
            .collect(Collectors.averagingInt(Person::getAge));

    System.out.println(avg);

    System.out.println();

    // 1.3 Суммиризатор - даёт статистику по потоку

    IntSummaryStatistics ageSummary = persons.stream()
            .collect(Collectors.summarizingInt(Person::getAge));

    System.out.println(ageSummary);

  }



}
