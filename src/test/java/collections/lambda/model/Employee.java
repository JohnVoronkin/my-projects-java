package collections.lambda.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
public class Employee {

  private int id;
  private String name;
  private String lastName;
  private int salary;

  public Employee(String name, String lastName, int salary) {
    this.name = name;
    this.lastName = lastName;
    this.salary = salary;
  }

}
