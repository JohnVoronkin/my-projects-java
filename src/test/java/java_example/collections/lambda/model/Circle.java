package java_example.collections.lambda.model;

public class Circle implements Shape, AnotherShape {

  public Circle() {
    System.out.println("Creating circle");
  }

  @Override
  public double calcSquare() {
    return 1;
  }

  @Override
  public double calcSomething() {
    return Shape.super.calcSomething();
  }
}
