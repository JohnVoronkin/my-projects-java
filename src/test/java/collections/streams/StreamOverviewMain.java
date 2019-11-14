package collections.streams;

import collections.lambda.model.Employee;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOverviewMain {

  private static List<Employee> employeeList = new ArrayList<>();
  private static Map<Integer, Employee> employeeMap;

  public static void main(String[] args) throws IOException {
    employeeList.add(new Employee(1, "Masha", "Sushkova", 19000));
    employeeList.add(new Employee(2, "Trish", "Black", 10000));
    employeeList.add(new Employee(3, "John", "Smith", 63000));
    employeeList.add(new Employee(4, "Grey", "White", 75000));
    employeeList.add(new Employee(9, "Alex", "Black", 50900));
    employeeList.add(new Employee(6, "John", "Smith", 60020));
    employeeList.add(new Employee(7, "Gomer", "White", 75000));
    employeeList.add(new Employee(10, "Misha", "Oker", 90000));

    // testStreamFromList();
    testStreamFromFile();

  }

  private static void testStreamFromList() {
    employeeList.stream()
            .filter(employee -> employee.getSalary() > 60000)
            .collect(Collectors.toList())
            .forEach(System.out::println);

    Integer[] ids = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    // создаём стрим из массива
    Stream.of(ids)
            .map(StreamOverviewMain::findById)
            .filter(Objects::nonNull)
            .collect(Collectors.toList())
            .forEach(System.out::println);

  }

  private static void testStreamFromFile() throws IOException {
    Files.lines(Paths.get("words.txt"))
            .filter(e -> e.length() > 4)
            .map(String::toUpperCase)
            .distinct()
            .sorted()
            .forEach(System.out::println);

  }

  private static Employee findById(int id) {
    if (employeeMap == null) {
      employeeMap = employeeList.stream().distinct().collect(Collectors.toMap(Employee::getId, e -> e));
    }
    return employeeMap.get(id);
  }


}
