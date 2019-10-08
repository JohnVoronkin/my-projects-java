package generics.company;

import generics.company.employees.Accountant;
import generics.company.employees.ITSpecialist;
import generics.company.employees.Manager;

public class CompanyMain {

  public static void main(String[] args) {
    Company company = new Company();

    Department accounting = new Department("accounting", 2);
    Department management = new Department("management", 3);
    Department itGuys = new Department("itGuys", 20);

    Accountant accountant = new Accountant("Alex", 1000.0f);
    ITSpecialist itSpecialist = new ITSpecialist("John", 2500.0f);
    Manager manager = new Manager("Roman", 1500.0f);

  }

}
