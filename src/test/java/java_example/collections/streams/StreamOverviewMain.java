package java_example.collections.streams;

import java_example.collections.lambda.model.Employee;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOverviewMain {

  private static List<Employee> employeeList = new ArrayList<>();
  private static List<Employee> secondEmployeeList = new ArrayList<>();
  private static List<Employee> threeEmployeeList = new ArrayList<>();
  private static Map<Integer, Employee> employeeMap;

  public static void main(String[] args) throws IOException {
    employeeList.add(new Employee(10, "Masha", "Sushkova", 19000));
    employeeList.add(new Employee(19, "Trish", "Black", 10000));
    employeeList.add(new Employee(3, "John", "Smith", 63000));
    employeeList.add(new Employee(4, "Grey", "White", 75000));
    employeeList.add(new Employee(9, "Alex", "Black", 50900));
    employeeList.add(new Employee(6, "John", "Smith", 60020));
    employeeList.add(new Employee(8, "Gomer", "White", 75000));
    employeeList.add(new Employee(10, "Misha", "Oker", 90000));

    secondEmployeeList.add(new Employee(1, "Masha", "Sushkova", 19000));
    secondEmployeeList.add(new Employee(2, "Trish", "Black", 10000));
    secondEmployeeList.add(new Employee(4, "John", "Smith", 63000));
    secondEmployeeList.add(new Employee(4, "Grey", "White", 75000));
    secondEmployeeList.add(new Employee(9, "Alex", "Black", 50900));
    secondEmployeeList.add(new Employee(6, "John", "Smith", 60020));
    secondEmployeeList.add(new Employee(7, "Gomer", "White", 75000));
    secondEmployeeList.add(new Employee(10, "Misha", "Oker", 90000));


    threeEmployeeList.add(new Employee(10, "Masha", "Sushkova", 19000, "IT"));
    threeEmployeeList.add(new Employee(19, "Trish", "Black", 10000, "IT"));
    threeEmployeeList.add(new Employee(3, "John", "Smith", 63000, "IT"));
    threeEmployeeList.add(new Employee(4, "Grey", "White", 75000, "Manager"));

    // testStreamFromList();
    // testStreamFromFile();

     testSortAndReduce();
    // partitionByIncome();
    // groupByCriterion(Employee::getDepartment);


  }

  // группируем Employee по какого-нибудь критерию
  public static <R> void groupByCriterion(Function<Employee, R> function) {
    Map<R, List<Employee>> collectedEmployees = threeEmployeeList.stream().collect(Collectors.groupingBy(function));
    // keySet - возвращает Set
    collectedEmployees.keySet().forEach(e -> System.out.println(e + "\n" + collectedEmployees.get(e)));
  }

  public static void partitionByIncome() {
    Map<Boolean, List<Employee>> collectedEmployees =
            threeEmployeeList.stream().collect(Collectors.partitioningBy(e -> e.getSalary() > 70000));
    System.out.println("poor employees");
    System.out.println(collectedEmployees.get(false));
    System.out.println("rich employees");
    System.out.println(collectedEmployees.get(true));
  }

  private static void testStreamFromList() {
    employeeList.stream()
            .filter(employee -> employee.getSalary() > 60000)
            .collect(Collectors.toList())
            .forEach(System.out::println);

    System.out.println("===");

    Integer[] ids = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    // создаём стрим из массива
    Stream.of(ids)
            .map(StreamOverviewMain::findById)
            .filter(Objects::nonNull)
            .collect(Collectors.toList())
            .forEach(System.out::println);

    List<List<Employee>> department = new ArrayList<>();
    department.add(employeeList);
    department.add(secondEmployeeList);

    department.stream().flatMap(l -> l.stream().map(Employee::getName)).forEach(System.out::println);

  }

  private static void testStreamFromFile() throws IOException {
    Files.lines(Paths.get("words.txt"))
            .filter(e -> e.length() > 4)
            .map(String::toUpperCase)
            //.distinct()
            //.sorted()
            .collect(Collectors.toCollection(ArrayList::new))
            .forEach(System.out::println);

  }

  private static void testSortAndReduce() {
    employeeList.stream()
            .sorted((s1, s2) -> s1.getName().compareTo(s2.getName()))
            .collect(Collectors.toList()).forEach(System.out::println);
    System.out.println("===");
    Employee max =
            employeeList.stream().max(Comparator.comparingInt(Employee::getId)).get();
    Employee min = employeeList.stream().min(Comparator.comparingInt(Employee::getSalary)).get();
    System.out.println(max);
    System.out.println(min);

    System.out.println("===");
    Employee identity = new Employee(0, "", "", 0);
    // сводим несколько объектов в один
    Employee reducedEmployee = employeeList.stream()
            .reduce(identity, (e1, e2) -> {
              e1.setId(e1.getId() + e2.getId());
              e1.setSalary(e1.getSalary() + e2.getSalary());
              return e1;
            });

    System.out.println(reducedEmployee);

  }

  private static Employee findById(final int id) {
    if (employeeMap == null) {
      employeeMap = employeeList.stream()
              .distinct().collect(Collectors.toMap(Employee::getId, e -> e));
    }
    return employeeMap.get(id);
  }


}
