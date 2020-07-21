package java_example.threads.producer_consumer;

import static java_example.threads.lesson93.ColorScheme.BLUE;
import static java_example.threads.lesson93.ColorScheme.RED;

public class WaitNotifyMain {

  public static void main(String[] args) {
    Message message = new Message();

    new Thread(new Producer(message)).start();
    new Thread(new Consumer(message)).start();

  }

  private static class Producer implements Runnable {

    private final Message message;

    private Producer(Message message) {
      this.message = message;
    }

    // источник сообщений к-е будут обрабатываться (сначала Producer, а потом Consumer)
    String[] texts = {
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
        e.printStackTrace();
      }
    }

    private void produce() throws InterruptedException {
      for (String text : texts) {
        synchronized (message) {
          System.out.println(BLUE + "producer message " + text);
          message.setMessage(text);
          message.notify(); // сообщает consumer, что новое сообщение для обработки готово
          if (!"DONE".equalsIgnoreCase(text))
            message.wait();
        }
        Thread.sleep(400);
      }
    }


  }

  private static class Consumer implements Runnable {

    private final Message message;

    private Consumer(Message message) {
      this.message = message;
    }

    @Override
    public void run() {
      try {
        consume();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    private void consume() throws InterruptedException {
      while (true) {
        Thread.sleep(400);
        synchronized (message) {
          System.out.println(RED + "consumer message: " + message.getMessage());
          if (!"DONE".equalsIgnoreCase(message.getMessage())) {
            message.notify();
            message.wait();
          } else return;
        }
      }
    }
  }
}
