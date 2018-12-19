package ru.simple.java.test.thread;

public class ClockManager {

  public static void main(String[] args) throws InterruptedException {
    Clock clock = new Clock();

    Thread clockThread = new Thread(clock);
    clockThread.start();
    Thread.sleep(5000);
    clockThread.interrupt();
  }

}
