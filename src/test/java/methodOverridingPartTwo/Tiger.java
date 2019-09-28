package methodOverridingPartTwo;

public class Tiger extends Cat {

  public Tiger getMyParent() {
    return (Tiger) this.parent;
  }
}
