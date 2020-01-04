package threads.producer_consumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static threads.lesson93.ColorScheme.GREEN;
import static threads.lesson93.ColorScheme.RED;

public class ProducerConsumer {

  // коллекция - промежуточное звено между Producer и Consumer, собственно это хранилище данных
  private static BlockingQueue<String> queue = new ArrayBlockingQueue<>(5); // 5 - размер очереди сколько мы можем сохранять

  public static void main(String[] args) {

    new Thread(new Producer()).start();
    new Thread(new Consumer()).start();

  }

  private static class Producer implements Runnable {

    // источник сообщений к-е будут обрабатываться (сначала Producer, а потом Consumer)
    String[] catsNames = {
            "Васька",
            "Кузя",
            "Барсик",
            "Мурзик",
            "Леопольд",
            "Бегемот",
            "Рыжик",
            "Матроскин",
            "DONE"
    };

    @Override
    public void run() {
      try {
        produce();
      } catch (InterruptedException e) {

      }
    }

    private void produce() throws InterruptedException {
      Random random = new Random();
      for (String catsName : catsNames) {
        queue.put(catsName); // добавление в коллекцию идет до 5 и далее она ждёт, пока Consumer не получит своего кота и не освободит одно место
        System.out.println(GREEN + "producing " + catsName + ". Queue size is " + queue.size());
        Thread.sleep(random.nextInt(1000));
      }
    }
  }

  private static class Consumer implements Runnable {

    @Override
    public void run() {
      try {
        consume();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    // consume должен получать данные из нашей коллекции queue
    private void consume() throws InterruptedException {
      Random random = new Random();
      while (true) {
        var messageTake = queue.take();
        System.out.println(RED + "consuming " + messageTake + ". Queue size is " + queue.size());
        if (!"DONE".equals(messageTake)) {
          Thread.sleep(random.nextInt(2000));
        } else return;

      }
    }
  }


}
