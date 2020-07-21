package java_example.collections;

import java.util.ArrayList;
import java.util.LinkedList;

public class PerformanceList {

  public static void main(String[] args) {
    ArrayList<Integer> arrayList = new ArrayList<>();
    LinkedList<Integer> linkedList = new LinkedList<>();

    final int I_100000 = 100_000;
    final int I_9999 = 9999;

    // ArrayList add
    long startTime = System.nanoTime();

    for (int i = 0; i < I_100000; i++) {
      arrayList.add(i);
    }
    long endTime = System.nanoTime();
    long duration = endTime - startTime;
    System.out.println("ArrayList add:  " + duration);

    // LinkedList add
    startTime = System.nanoTime();

    for (int i = 0; i < I_100000; i++) {
      linkedList.add(i);
    }
    endTime = System.nanoTime();
    duration = endTime - startTime;
    System.out.println("LinkedList add: " + duration);

    System.out.println("===============");
    // ArrayList get
    startTime = System.nanoTime();

    for (int i = 0; i < I_100000; i++) {
      arrayList.get(i);
    }
    endTime = System.nanoTime();
    duration = endTime - startTime;
    System.out.println("ArrayList get:  " + duration);

    // LinkedList get
    startTime = System.nanoTime();

    for (int i = 0; i < I_100000; i++) {
      linkedList.get(i);
    }
    endTime = System.nanoTime();
    duration = endTime - startTime;
    System.out.println("LinkedList get: " + duration);

    System.out.println("===============");
    // ArrayList remove
    startTime = System.nanoTime();

    for (int i = I_9999; i >= 0; i--) {
      arrayList.remove(i);
    }
    endTime = System.nanoTime();
    duration = endTime - startTime;
    System.out.println("ArrayList remove:  " + duration);


    // LinkedList remove
    startTime = System.nanoTime();

    for (int i = I_9999; i >= 0; i--) {
      linkedList.remove(i);
    }
    endTime = System.nanoTime();
    duration = endTime - startTime;
    System.out.println("LinkedList remove: " + duration);
  }

}
