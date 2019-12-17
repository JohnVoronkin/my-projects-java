package collections.lambda.model;

import collections.generics.company.Department;
import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
public class Employee {

  private int id;
  private String name;
  private String lastName;
  private int salary;
  private String department;

  public Employee(String name, String lastName, int salary) {
    this.name = name;
    this.lastName = lastName;
    this.salary = salary;
  }

  public Employee(int id, String name, String lastName, int salary) {
    this.id = id;
    this.name = name;
    this.lastName = lastName;
    this.salary = salary;
  }

  public Employee(String name, String lastName, int salary, String department) {
    this.name = name;
    this.lastName = lastName;
    this.salary = salary;
    this.department = department;
  }

}
