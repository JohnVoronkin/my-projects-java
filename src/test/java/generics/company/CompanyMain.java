package generics.company;

import generics.company.employees.Accountant;
import generics.company.employees.ITSpecialist;
import generics.company.employees.Manager;

public class CompanyMain {

  public static void main(String[] args) {
    Company company = new Company();

    Department<Accountant> accounting = new Department<>("accounting", 2);
    Department<Manager> management = new Department<>("management", 3);
    Department<ITSpecialist> itGuys = new Department<>("itGuys", 20);

    Accountant accountant = new Accountant("Alex", 1000.0f);
    ITSpecialist itSpecialist = new ITSpecialist("John", 2500.0f);
    Manager manager = new Manager("Roman", 1500.0f);

    accounting.addEmployee(accountant);
    management.addEmployee(manager);
    itGuys.addEmployee(itSpecialist);

    company.addDepartment(accounting);
    company.addDepartment(management);
    company.addDepartment(itGuys);

    company.print(company.getDepartments());
    company.print(company.getEmployees());
    System.out.println();
    company.addToItEmployees(itGuys.getEmployees());
    company.addToItEmployees(company.getEmployees());

  }

}
