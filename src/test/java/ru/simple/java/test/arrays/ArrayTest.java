package ru.simple.java.test.arrays;

import java.io.IOException;
import java.util.Arrays;

public class ArrayTest {

  public static void main(String[] args) throws IOException {
    minArray();
    sumElementArrays();
    twoDimensionalArray();
  }

  private static void minArray() {
    int[] list = {5, 6, 7, 8, 1, 2, 5, -7, -9, 2, 0};

    int min = list[0];
    for (int i = 1; i < list.length; i++) {
      if (list[i] < min)
        min = list[i];
    }

    System.out.println("Min is " + min + "\n");
  }

  private static void sumElementArrays() {
    //это статическая инициализация
    int[] list = {5, 6, 7, 8, 1, 2, 5, -7, -9, 2, 0};

    //подсчёт суммы элементов
    int sum = 0;
    for (int i = 0; i < list.length; i++)
      sum += list[i];

    System.out.println("Sum is " + sum + "\n");
  }


  private static void twoDimensionalArray() {

    int[][] array = new int[3][3];
    // столбец / строка
    array[0][0] = 12;
    array[2][1] = 32;
    array[1][0] = 1;
    array[1][1] = 3;
    array[2][2] = 543;

    for (int i = 0; i < array.length; i++) {
      System.out.println(Arrays.toString(array[i]));
    }


  }
}
