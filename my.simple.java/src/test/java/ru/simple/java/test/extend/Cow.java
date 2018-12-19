package ru.simple.java.test.extend;

public class Cow {

  public void printAll()
  {
    printColor();
    printName();
  }

  public void printColor() {
    System.out.println("Я - белая");
  }

  public void printName() {
    System.out.println("Я - корова");
  }

}
