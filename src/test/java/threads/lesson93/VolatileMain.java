package thread.lesson93;

public class VolatileMain {

  private static volatile int counter;
  private static int x;
  private static int y;

  public static void main(String[] args) {

    new Thread(new SimpleWriter()).start();
    new Thread(new SimpleReader()).start();

  }

  private static class SimpleWriter implements Runnable {

    @Override
    public void run() {
      int localCounter = counter;
      for (int i = 0; i < 10; i++) {
        System.out.println(ColorScheme.GREEN + "writer increments counter " + (localCounter + 1));
        counter = ++localCounter;
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }

  private static class SimpleReader implements Runnable {

    @Override
    public void run() {
      int localCounter = counter;
      while (localCounter < 10) {
        if (localCounter != counter) {
          System.out.println(ColorScheme.BLUE + "reader reads counter " + counter);
          localCounter = counter;
        }
      }

    }
  }

}
