package ru.simple.java.test.fori;

/**
 * Использование break, как цивилизованной формы goto.
 */
public class LabbelForiTets {

  public static void main(String[] args) {
    boolean t = true;
    first:
    {
      second:
      {
        third:
        {
          System.out.println("Перед оператором break.");
          if (t) {
            break second; // выход из блока second
          }
          System.out.println("Данный оператор никогда не выполнится");
        }
        System.out.println("Данный оператор никогда не выполнится - вот, правда, правда!");
      }
      System.out.println("Данный оператор размещен после блока second.");
    }

    System.out.println("===");

    outer:
    {
      for (int i = 0; i < 3; i++) {
        System.out.print("Итерация " + i + ": ");
        for (int j = 0; j < 100; j++) {

          if (j == 10) {
            break outer; // выйти из обоих циклов
          }
          System.out.print(j + " ");
        }
        System.out.println("Эта строка никогда не будет выведена");
      }
    }
    System.out.println("Цикл завершен.");
  }
}
