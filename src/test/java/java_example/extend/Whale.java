package java_example.extend;

public class Whale extends Cow {

  @Override
  public void printName() {
    super.printName(); // вызов реализации метода класса родителя
    System.out.println("Я - кит");
  }

  public void printSwim() {
    System.out.println("Я - плыву");
  }

}
