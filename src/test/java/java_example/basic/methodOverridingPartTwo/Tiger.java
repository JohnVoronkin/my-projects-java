package java_example.basic.methodOverridingPartTwo;

public class Tiger extends Cat {

  public Tiger getMyParent() {
    return (Tiger) this.parent;
  }
}
