package java_example.collections.generics.company;

import java_example.collections.generics.company.employees.Employee;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Department<T extends Employee> {

  private String name;
  private int employeeNumber;
  private List<T> employees = new ArrayList<>();

  public Department(String name, int employeeNumber) {
    this.name = name;
    this.employeeNumber = employeeNumber;
  }

  public boolean addEmployee(T employees) {
    return this.employees.add(employees);
  }





}
