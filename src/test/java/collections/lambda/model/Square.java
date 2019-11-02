package collections.lambda.model;

public class Square implements Shape {

  public Square() {
    System.out.println("creating square");
  }

  @Override
  public double calcSquare() {
    return 2;
  }

}
