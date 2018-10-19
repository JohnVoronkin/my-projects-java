package ru.simple.java.test.simple;

public class Test {

  public static void main(String[] args) {

    Cat cat = new Cat();
    System.out.println(cat.getName());

    System.out.println("---");

    Tiger tiger = new Tiger();
    System.out.println(tiger.getName());
    System.out.println(tiger.getPublicName());

    System.out.println("---");

    Cat catTiger = new Tiger();
    System.out.println(catTiger.getName());

  }

  static class Cat {

    public String getName() {
      return "Васька";
    }

    public void getMethodParent() {

    }

  }

  static class Tiger extends Cat implements HasName {

    @Override
    public int getWeight() {
      return 115;
    }


    public String getPublicName() {
      return super.getName(); //вызов protected метода
    }


    @Override
    public String getName() {
      return "Василий Тигранович";
    }


  }

  interface HasName {

    String getName();

    int getWeight();
  }


}
