package threads.locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static threads.lesson93.ColorScheme.RED;

public class SynchronizedBuffer {

  private static final Lock monitor = new ReentrantLock();
  public static final Condition canRead = monitor.newCondition();
  public static final Condition canWrite = monitor.newCondition();

  private static int buffer = 0;
  private static boolean isEmpty = true;

  public static void main(String[] args) {
    new Thread(SynchronizedBuffer::blockingWrite).start();
    new Thread(SynchronizedBuffer::blockingRead).start();
  }


  private static void blockingWrite() {
    for (int i = 0; i < 10; i++) {
   /*
   т.о. оборачиваем какой-то код, к к-му должен иметь доступ в один момент времени только один поток
   synchronized (SynchronizedBuffer.class) {}
    Имеется аналогичный вызов (lock и unlock)
    */
      monitor.lock();
      buffer++;
      isEmpty = false;
      System.out.println(RED + "Writer produced " + buffer);

      monitor.unlock();
    }

  }

  private static void blockingRead() {
    for (int i = 0; i < 10; i++) {
      monitor.lock();
      int readValue = buffer;
      isEmpty = true;
      System.out.println(RED + "Reader reads from buffer " + readValue);

      monitor.unlock();
    }
  }

}



