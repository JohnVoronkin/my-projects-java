package ru.simple.java.test.simple.methodOverridingPartTwo;

public class Tiger extends Cat {

  public Tiger getMyParent() {
    return (Tiger) this.parent;
  }
}
