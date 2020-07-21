package java_example.threads.terminationThread;

import java.util.Random;

import static java_example.threads.lesson93.ColorScheme.BLUE;
import static java_example.threads.lesson93.ColorScheme.GREEN;

// в данном классе мы ищем самый большой делитель двух чисел
public class GCDRunnable extends Random implements Runnable {

  public GCDRunnable() {

  }

  @Override
  public void run() {
    // получаем имя потока
    String threadDescription = Thread.currentThread().getName();

    System.out.println(BLUE + "Starting " + threadDescription);
    for (int i = 0; i < 10_000_000; i++) {
      int a = nextInt();
      int b = nextInt();
      if (i % 10_000 == 0) {
        if (!Thread.interrupted()) {
          int gcd = computeGCD(a, b);
          if (gcd > 5) {
            System.out.println(GREEN + "Running in " + threadDescription + ". The GCD of " + a + " and " + b + " in " + gcd);
          }
        } else {
          System.out.println(BLUE + "thread was interrupted");
          return;
        }
      }
    }
    System.out.println(BLUE + "Leaving the thread " + threadDescription);
  }

  // находим самый большой делитель двух чисел
  private int computeGCD(int number1, int number2) {
    if (number2 == 0)
      return number1;
    /*
    50 % 30 = 20
    computeGCD(30, 20);
    and etc..
     */
    else return computeGCD(number2, number1 % number2);
  }


}
