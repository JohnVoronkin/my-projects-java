package generics.company;

import generics.company.employees.Employee;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class Company {

  private List<Department> departments = new ArrayList<>();
  private List<Employee> employees = new ArrayList<>();

  public void addDepartment(Department department) {
    this.departments.add(department);
    List<Employee> employeesList = department.getEmployees();
    this.employees.addAll(employeesList);
  }


}
