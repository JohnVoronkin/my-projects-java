package ru.simple.java.test.simple;

public class MyTest {

  public static void main(String[] args) {
    A a = new B(1);
  }
}

class A {
  A() {
    System.out.println("A");
  }

  {
    System.out.println("AC");
  }

  static {
    System.out.println("AK");
  }

}

class B extends A {
  B(int i) {
    this();
    System.out.println("B");
  }

  {
    System.out.println("BC");
  }

  B() {
    System.out.println("def B");
  }

  {
    System.out.println("BC2");
  }

  static {
    System.out.println("BK");
  }
}
