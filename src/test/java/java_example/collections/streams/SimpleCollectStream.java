package java_example.collections.streams;

import domain.person.Person;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SimpleCollectStream {

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

    IntSummaryStatistics ageSummary = persons
            .stream()
            .collect(Collectors.summarizingInt(Person::getAge));

    System.out.println(ageSummary);

    System.out.println();

    // 1.4 joining - даёт статистику по потоку
    String phrase = persons
            .stream()
            .filter(p -> p.getAge() >= 18) // фильтруем объекты по возрасту
            .map(Person::getName) // мапим (получаем) Имена
            .collect(Collectors.joining(" и ", "В Германии ", " совершеннолетние"));

    System.out.println(phrase);

    System.out.println();

    // 1.5 трансформируем элементы потока в Map
    Map<Integer, String> map = persons
            .stream()
            .collect(Collectors.toMap(
                    Person::getAge,
                    Person::getName,
                    (name1, name2) -> name1 + ";" + name2
            ));

    System.out.println(map);

    System.out.println();

    // 1.6 кастомизируем collector
    Collector<Person, StringJoiner, String> personNameCollector =
            Collector.of(
                    () -> new StringJoiner(" | "), // supplier
                    (j, p) -> j.add(p.getName().toUpperCase()), // accumulator
                    StringJoiner::merge, // combiner
                    StringJoiner::toString // finisher
            );

    String names = persons.stream()
            .collect(personNameCollector);

    System.out.println(names);

  }


}
