package fori;

/**
 * continue
 */
public class ContinueForiTest {

  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      System.out.print(i + " ");
      if (i % 2 == 0) {
        continue;
      }
      System.out.println("");
    }

    System.out.println("===");

    outer:
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        if (j > i) {
          System.out.println();
          continue outer;
        }
        System.out.print(" " + (i * j));
      }
    }
    System.out.println();
  }

}
