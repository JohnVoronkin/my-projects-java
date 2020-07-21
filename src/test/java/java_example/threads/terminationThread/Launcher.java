package java_example.threads.terminationThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import static java_example.threads.lesson93.ColorScheme.RED;

// User VS Daemon java_example.threads
public class Launcher {
  // кол-во потоков
  public static final int POOL_SIZE = 2;
  public static final int TASK = 5;

  public static void main(String[] args) throws InterruptedException {
    boolean isDaemon = true;
    System.out.println(RED + "starting main thread");
    GCDRunnable runnable = new GCDRunnable();
    // runInOneThread(runnable, isDaemon);
    runWithExecutors(runnable, isDaemon);
    System.out.println(RED + "leaving the main thread");
  }

  private static void runInOneThread(GCDRunnable runnable, boolean isDaemon) throws InterruptedException {
    Thread th = new Thread(runnable);
    if (isDaemon) {
      th.setDaemon(true);
    }
    th.start();
    th.interrupt();
  }

  private static void runWithExecutors(GCDRunnable runnable, boolean isDaemon) throws InterruptedException {

    ThreadFactory factory = runnable1 -> {
      Thread thread = new Thread(runnable1);
      if (isDaemon) {
        thread.setDaemon(true);
      }
      return thread;
    };

    ExecutorService executorService = Executors.newFixedThreadPool(POOL_SIZE, factory);
    // все задания (task), к-е не получили свой поток должны стать в очередь
    for (int i = 0; i < TASK; i++) {
      executorService.execute(runnable);
    }
    /*
     потоки не принимает больше новых заданий, т.е. executor service должен завершить
    свою работу после того как все потоки выполнят свои задания
     */
    executorService.shutdown();

    /*
    некоторые потоки могут висеть в памяти не завершая свою работу - поток ожидает длительное время своего lock'a
     */
    // если потоки, по какой-либо причине зависли, они будут завершены в течении 30 сек..
    executorService.awaitTermination(30, TimeUnit.SECONDS);

  }


}
