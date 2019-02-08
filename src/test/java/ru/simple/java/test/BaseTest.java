package ru.simple.java.test;

public class BaseTest {

  private final static String RED = "красный";
  private final static String BLUE = "синий";

  public static void main(String[] args) {

    new BaseTest().freeSpacesParking(19);

  }

  private void freeSpacesParking(final int ratio) {
    if (ratio >= 0 && ratio < 20) {
      System.out.println(RED);
    } else System.out.println(BLUE);
  }
}
