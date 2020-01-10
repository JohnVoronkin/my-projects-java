package threads.lesson93;

public class ConcurrentMain {

  public static void main(String[] args) {
    // 1-й Способ создания нового потока
    var th0 = new SimpleThread();
    th0.start();

    System.out.println("hello from main");

    var th1 = new SimpleThread();
    th1.start();
    th1.interrupt();

    // 2-й Способ создания нового потока
    Thread th2 = new Thread(new SimpleRunner());
    th2.start();

    // еще один (3-й) способ создания потока - с помощью lambda выражения
    new Thread(() -> System.out.println(ColorScheme.BLUE + "hello from Lambda Runnable")).start();

  }
}

class SimpleThread extends Thread {
  // тут указывается тот код, к-й должен выполнится в отдельном потоке
  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      try {
        sleep(1000);
      } catch (InterruptedException e) {
        System.out.println(ColorScheme.YELLOW + "WARN - " + currentThread().getName() + " was interrupted " + i);
        return;
      }
      // currentThread().getName() - выводит имя текущего потока
      System.out.println(ColorScheme.BLUE + "INFO - " + currentThread().getName() + " - " + i);
    }
  }
}

// еще один способ создания нового потока (выполнение кода в отдельном потоке)
class SimpleRunner implements Runnable {

  @Override
  public void run() {
    // Thread.currentThread().setName("Runnable Thread");
    for (int i = 0; i < 10; i++) {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        System.out.println(ColorScheme.YELLOW + "WARN - " + Thread.currentThread().getName() + " was interrupted " + i);
        return;
      }
      // currentThread().getName() - выводит имя текущего потока
      System.out.println(ColorScheme.BLUE + "INFO - Runnable" + Thread.currentThread().getName() + " - " + i);
    }
  }
}
