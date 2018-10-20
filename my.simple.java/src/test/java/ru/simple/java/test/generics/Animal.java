package ru.simple.java.test.generic;

public class Animal extends LiveView {

  private int id;

  public Animal() {

  }

  public Animal(int id) {
    this.id = id;
  }

  public void eat() {
    System.out.println("Animal ням-ням...");
  }

  @Override
  public String toString() {
    return "Animal{" +
            "id=" + id +
            '}';
  }
}
