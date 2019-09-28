package ru.simple.java.test;

public class BaseTest {

  private final static String RED = "красный";
  private final static String YELLOW = "желтый";
  private final static String GREEN = "зеленый";
  private final static String BLUE = "синий";

  public static void main(String[] args) {

    new BaseTest().freeSpacesParking(49);

  }

  private void freeSpacesParking(final Integer ratio) {
    if (ratio >= 0 && ratio <= 20)
      System.out.println(RED);
    else if (ratio > 20 && ratio <= 49)
      System.out.println(YELLOW);
    else if (ratio >= 50)
      System.out.println(GREEN);
    else System.out.println(BLUE);
  }
}
