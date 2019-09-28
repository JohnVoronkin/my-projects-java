package thread;

public class MyFirstThread extends Thread {

  @Override
  public void run() {
    System.out.println("I'm thread. My name " + getName());
  }


}
