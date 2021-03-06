package java_example.collections.streams;

import domain.person.Person;
import domain.person.PersonCollect;

import java.util.Comparator;


public class PersonCollectTest {
  public static void main(String[] args) {
    PersonCollect p = new PersonCollect();

    // если надо вывести только людей старше 20 лет, то код будет таким
    double averageAge = p.persons()
            .filter(x -> x.getAge() > 18)
            .sorted(Comparator.comparing(Person::getName))
            // map - позволяет превратить наши объекты класса Personal в наборы других данных
            .mapToInt(Person::getAge).average().getAsDouble();

    System.out.println(averageAge);

    new Person().addActor(
            () -> System.out.println("one"),
            () -> System.out.println("two"))
            .act();

  }

}
