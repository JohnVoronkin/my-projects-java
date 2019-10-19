package generics;

public class MyBox<X> {

  public <T> MyBox(T param) {
    System.out.println(param.getClass().getSimpleName());
  }

}

