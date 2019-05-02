package ru.simple.java.test.lists.generics;

public class Dog extends Animal {

  protected void bark(){
    System.out.println("Собачка гав-гав");
  }

  @Override
  public void eat() {
    System.out.println("Собачка нам-ням");
  }

  @Override
  public String toString() {
    return "Dog{}";
  }
}
