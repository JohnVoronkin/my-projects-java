package thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class AsynchronousTest {

    //for simulate issue
    static boolean ready = false;
    static final Object monitor = new Object();

    //for resolve issue
    static AtomicInteger result = new AtomicInteger();
    static CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            int value = findOutThePriceOfAFlatParking();
            result.set(value);
            latch.countDown();

        };
        Thread thread = new Thread(task);
        thread.start();

      /*  int value = findOutThePriceOfAFlatParking();
        result.set(value);*/

        Thread.sleep(2000);

        request();

        latch.await();
        System.out.println("Result: " + result.get());
    }

    private static int findOutThePriceOfAFlatParking() {
        synchronized (monitor) {
            while (!ready) {
                try {
                    System.out.println("wait");
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return 20;
    }

    private static void request() {
        synchronized (monitor) {
            System.out.println("notifyAll");
            ready = true;
            monitor.notifyAll();
        }
    }

}
