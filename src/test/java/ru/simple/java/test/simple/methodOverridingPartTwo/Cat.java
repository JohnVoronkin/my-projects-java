package ru.simple.java.test.simple.methodOverridingPartTwo;

public class Cat {

  // Расширение типа результата
  public Cat parent;

  public Cat getMyParent() {
    return this.parent;
  }

  public void setMyParent(Cat cat) {
    this.parent = cat;
  }
}
