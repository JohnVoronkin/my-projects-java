package threads.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static threads.lesson93.ColorScheme.BLUE;
import static threads.lesson93.ColorScheme.RED;

public class LockSynchronizedBufferMain {

  private static final Lock monitor = new ReentrantLock(true);
  /*
   для того чтобы установить взаимодействие между двумя потоками - между Reader и Writer.
    Они аналогично используются wait() и notify() - суть их таже. Т.е., например, для уведомления, что новое значение записано и можно
    прочитать.
   */
  public static final Condition canRead = monitor.newCondition();
  public static final Condition canWrite = monitor.newCondition();

  // переменное значение, к-е будет использоваться двумя потоками
  private static int buffer = 0;
  // проверяется - пустой или не пустой ли buffer (т.е. пора ли читать значение переменной или еще нет)
  private static boolean isEmpty = true; // true - buffer пустой (empty)

  public static void main(String[] args) {
    new Thread(LockSynchronizedBufferMain::blockingWrite).start();
    new Thread(LockSynchronizedBufferMain::blockingRead).start();
  }


  private static void blockingWrite() {
    for (int i = 0; i < 10; i++) {
   /*
   т.о. оборачиваем какой-то код, к к-му должен иметь доступ в один момент времени только один поток
   synchronized (SynchronizedBuffer.class) {}
    Имеется аналогичный вызов (lock и unlock)
    */
      monitor.lock();
      try {
        while (!isEmpty) {
          System.out.println(RED + "Writer пытается получить доступ к ресурсу");
          System.out.println(RED + "buffer у нас полный!");
          canWrite.await(5, TimeUnit.SECONDS); // получить сигнал в Reader и остановить работу нашего Writer
        }
        buffer++;
        isEmpty = false;
        System.out.println(RED + "Writer produced: " + buffer);
        canRead.signal(); // т.о. просигналить Reader, что можно прочитать


      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        monitor.unlock();
      }
    }

  }

  private static void blockingRead() {
    for (int i = 0; i < 10; i++) {
      monitor.lock();
      try {
        while (isEmpty) {
          System.out.println(BLUE + "Reader пытается получить доступ к ресурсу");
          System.out.println(BLUE + "buffer у нас пустой!");
          canRead.await(5, TimeUnit.SECONDS); // reader, пусть пока подождет
        }
        int readValue = buffer;
        isEmpty = true;
        System.out.println(BLUE + "Reader reads from buffer: " + readValue);
        canWrite.signal(); // writer может продолжить записывать
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        monitor.unlock();
      }
    }
  }

}



