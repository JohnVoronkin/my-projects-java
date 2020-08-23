package domain.consumer.person;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Класс Person для собирания данных в коллекцию.
 */
public class PersonCollect {

  private List<Person> persons = new ArrayList<>();

  /*
   * метод persons(), который будет возвращать стрим, т.е. если мы захотим как-то модифицировать
   * коллекцию, то будем писать меньше кода.
   */
  public Stream<Person> persons() {
    return getAllPersons().stream();
  }

  /*
  Метод getAllPersons собирает данные в коллекцию lists. Данные могут храниться где угодно: БД, Excel, в самом коде
   */
  public List<Person> getAllPersons() {
    if (persons.isEmpty()) {
      persons = Arrays.asList(
              new Person("Andrew", 17),
              new Person("Igor", 38),
              new Person("Ira", 6),
              new Person("Maxim", 24),
              new Person("John", 18)
      );
    }
    return persons;
  }

}