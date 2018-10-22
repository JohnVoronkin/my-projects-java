package ru.simple.java.test;

public class InitializationPriority {

  public static void main(String[] args) {
    A a = new B(1);
  }
}

class A {
  A() {
    System.out.println("вызов - конструктора родителя - \"4\"");
  }

  {
    System.out.println("\"3\"");
  }

  static {
    System.out.println("вызов - static метод родителя \"1\"");
  }

}

class B extends A {
  B(int i) {
    this();
    System.out.println("B");
  }

  {
    System.out.println("\"5\"");
  }

  B() {
    System.out.println("вызов - конструктора потомка - \"7\"");
  }

  {
    System.out.println("\"5.1\"");
  }

  static {
    System.out.println("вызов - static метод потомка \"2\"");
  }
}
