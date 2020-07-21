package java_example.collections.lambda;

import java_example.collections.lambda.model.Employee;
import java_example.collections.lambda.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaFunctionMain {

  public static void main(String[] args) {
    List<Employee> employees = new ArrayList<>();
    employees.add(new Employee("Alex", "Black", 50000));
    employees.add(new Employee("John", "Smith", 60000));
    employees.add(new Employee("Alex", "White", 75000));

    List<Person> persons = new ArrayList<>();
    persons.add(new Person("Alex", "Black", 24));
    persons.add(new Person("John", "Smith", 38));
    persons.add(new Person("Alex", "White", 24));

    // predicate
    System.out.println(findMatch(employees, employee -> employee.getSalary() > 60000));

    // function
    System.out.println("total salary " + calcSum(employees, Employee::getSalary));
    System.out.println("total age " + calcSum(persons, Person::getAge));

    // это именно то действие (сложение, вычитание и пр.), к-е мы будем совершать в методе combine
    BinaryOperator<Integer> operatorSum = Integer::sum;
    BinaryOperator<Integer> operatorMax = Integer::max;
    Integer zeroElement = 0;
    System.out.println("combined salary sum " + combine(employees, zeroElement, Employee::getSalary, operatorSum));
    System.out.println("combined salary max " + combine(employees, zeroElement, Employee::getSalary, operatorMax));

    // interface - Consumer, например, необходим для изменения елеменотов текущей коллекции
    employees.forEach(employee -> employee.setSalary(employee.getSalary() * 11 / 10)); // меняем з/п сотрудникам
    employees.forEach(System.out::println);

  }

  public static <T> T findMatch(List<T> elements, Predicate<T> predicateFunction) {
    for (T e : elements) {
      if (predicateFunction.test(e)) {
        return e;
      }
    }
    return null;
  }

  public static <T> int calcSum(List<T> elements, Function<T, Integer> function) {
    int sum = 0;
    for (T e : elements) {
      sum += function.apply(e);
    }
    return sum;
  }

  public static <T, R> R combine(List<T> elements, R zeroElement, Function<T, R> function,
                                 BinaryOperator<R> combiner) {
    for (T e : elements) {
      zeroElement = combiner.apply(zeroElement, function.apply(e));
    }
    return zeroElement;
  }

}
