package thread.lesson93;

public class SynchronizedMain {

  private static int previous = 0;
  private static int current = 1;

  public static void main(String[] args) {
    var thread1 = new Thread(new FibonacciRunner());
    var thread2 = new Thread(new FibonacciRunner());

    thread1.start();
    thread2.start();
  }

  private static synchronized int calcNext() {
    int next = previous + current;
    previous = current;
    return current = next;
  }

  // Фибоначчи ряд - каждый новый элемент равняется сумме двух предыдущих
  private static class FibonacciRunner implements Runnable {

    @Override
    public void run() {
      for (int i = 0; i < 10; i++) {
        System.out.println(calcNext());
      }
    }
  }

}
