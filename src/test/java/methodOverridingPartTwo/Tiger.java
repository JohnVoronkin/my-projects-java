package ru.simple.java.test.methodOverridingPartTwo;

public class Tiger extends Cat {

  public Tiger getMyParent() {
    return (Tiger) this.parent;
  }
}
