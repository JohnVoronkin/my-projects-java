package generics;

public class GenericsMethods {

  public static void main(String[] args) {

    Integer[] intArray = {1, 2, 23, 8, 5, 20};
    Double[] doubleArray = {0.231, 6.32, 91.1, 12.9, 37.1};
    String[] stringArray = {"abc", "vgf", "djq", "djw", "arwq"};

    printArray(intArray);
    printArray(doubleArray);
    printArray(stringArray);

    System.out.println("max array int " + findMax(intArray));
    System.out.println("max array double " + findMax(doubleArray));
    // System.out.println("max array string " + findMax(stringArray));

  }

  private static <T> void printArray(T[] intArray) {
    System.out.println("genetic method called");
    for (T element : intArray) {
      System.out.printf("%s, ", element);
    }
    System.out.println();
  }

  private static <T extends Number & Comparable<T>> T findMax(T[] array) {
    T max = array[0];
    for (T e : array) {
      if (e.compareTo(max) > 0) {
        max = e;
      }
    }
    return max;
  }

}
