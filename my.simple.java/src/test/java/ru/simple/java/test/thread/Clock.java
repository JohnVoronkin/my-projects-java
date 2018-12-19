package ru.simple.java.test.thread;

public class Clock implements Runnable {

  @Override
  public void run() {

    Thread current = Thread.currentThread();

    while (!current.isInterrupted()) {
      try {
        Thread.sleep(1000);
        System.out.println("Tik");
      } catch (InterruptedException e) {
        break;
      }

    }
  }
}
