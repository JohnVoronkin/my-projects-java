package ru.simple.java.test.ArrayListCollectPerson;

import ru.simple.java.test.model.Person.Person;
import ru.simple.java.test.model.Person.PersonCollect;

import java.util.List;
import java.util.stream.Collectors;


public class PersonCollectTest {
    public static void main(String[] args) {
        PersonCollect p = new PersonCollect();
        /*
         метод persons(), который будет возвращать стрим, т.е. если мы захотим как-то модифицировать
         коллекцию, то будем писать меньше кода.
          */
        // если надо вывести только людей старше 20 лет, то код будет таким
        List<Person> older20 = p.persons().filter(x -> x.getAge() > 20).collect(Collectors.toList());
        System.out.println(older20);
    }

}
