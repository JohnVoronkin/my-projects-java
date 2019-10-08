package generics.company;

import generics.company.employees.Employee;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Department {

  private String name;
  private int employeeNumber;
  private List<Employee> employees = new ArrayList<>();

  public Department(String name, int employeeNumber) {
    this.name = name;
    this.employeeNumber = employeeNumber;
  }

  public boolean addEmployee(Employee employees) {
    return this.employees.add(employees);
  }





}
