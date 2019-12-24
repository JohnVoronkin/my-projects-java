package thread.lesson93;

import java.util.ArrayList;
import java.util.List;

public class SynchronizedBlocksMain {

  private int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
  private int[] b = {0, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
  private List<Integer> intList1 = new ArrayList<>();
  private List<Integer> intList2 = new ArrayList<>();

  private final Object lock1 = new Object();
  private final Object lock2 = new Object();

  public static void main(String[] args) {
    SynchronizedBlocksMain sb = new SynchronizedBlocksMain();
    sb.copy();
  }

  private void copy() {
    long start = System.currentTimeMillis();

    var th1 = new Thread(new RunnerA());
    var th2 = new Thread(new RunnerB());
    th1.start();
    th2.start();

    /*
    метод main должен ждать выполнение потока th1 и потока th2 и только после этого
    выполнять следующие выражение
     */
    try {
      th1.join();
      th2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }


    long end = System.currentTimeMillis();
    System.out.println("time taken : " + (end - start) + " ms");

  }

  private void copyArrayA() {
    synchronized (lock1) {
      for (int i = 0; i < a.length; i++) {
        intList1.add(a[i]);
        System.out.println(intList1);
        try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }

  private synchronized void copyArrayB() {
    // т.о. два метода мы делаем независимыми и они НЕ должны ждать выполнения др. друга
    synchronized (lock2) {
      for (int i = 0; i < b.length; i++) {
        intList2.add(b[i]);
        System.out.println(intList2);
        try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }

  private class RunnerA implements Runnable {

    @Override
    public void run() {
      copyArrayA();
    }
  }

  private class RunnerB implements Runnable {

    @Override
    public void run() {
      copyArrayB();
    }
  }


}
