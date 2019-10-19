package collections.generics.company;

import collections.generics.company.employees.Employee;
import collections.generics.company.employees.ITSpecialist;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class Company {

  private List<Department> departments = new ArrayList<>();
  private List<Employee> employees = new ArrayList<>();

  public <T extends Employee> void addDepartment(Department<T> department) {
    this.departments.add(department);
    List<T> employeesList = department.getEmployees();
    giveRise(employeesList);
    this.employees.addAll(employeesList);
  }

  private void giveRise(List<? extends Employee> employees) {
    for (Employee employee : employees) {
      var rise = employee.getSalary() * 0.2f;
      employee.setSalary(employee.getSalary() + rise);
    }
  }

  public void print(List<?> list) {
    System.out.println("size " + list.size());
    System.out.println(list);
  }

  public void addToItEmployees(List<? super ITSpecialist> list) {
    list.add(new ITSpecialist("Bob", 3000f));

  }


}
