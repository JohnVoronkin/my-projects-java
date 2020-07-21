package java_example.collections.lambda;

import java_example.collections.lambda.model.Circle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@FunctionalInterface
interface ElementProcessor<T extends Number> {
  double process(T element);
}

@FunctionalInterface
interface Operation {

  void process();

  static void measure(Operation function) {
    long start = System.currentTimeMillis();
    function.process();
    long end = System.currentTimeMillis();
    System.out.println("time spent " + (end - start));
  }

  default Operation combineOperation(Operation that) {
    return () -> {
      process();
      that.process();
    };
  }

}

public class LambdaExample {

  public static void main(String[] args) {
    List<Integer> intList = new ArrayList<>();
    intList.add(1);
    intList.add(10);
    intList.add(4);
    intList.add(2);

    List<Double> doubleList = new ArrayList<>();
    doubleList.add(1.19);
    doubleList.add(7.9);
    doubleList.add(17.18);
    doubleList.add(28.1);

    processElements(intList, x -> Math.sin(x.doubleValue()));
    processElements(doubleList, x -> Math.sin(x.doubleValue()));
    System.out.println("start");
   // Operation.measure(() -> Arrays.sort(createRandomArray()));
    System.out.println("the end");

    Operation operation1 = () -> Arrays.sort(createRandomArray());
    Operation operation2 = () -> Arrays.sort(createRandomArray());

    Operation.measure(operation1.combineOperation(operation2));

    // processStrings();

    Circle circle = new Circle();
    System.out.println(circle.calcSomething());

  }

  private static void processStrings() {
    String helloText = "Hello ";
    Double d = 0.123;

    var doubleTransformUtils = new TransformUtils<Double>();
    doubleTransformUtils.transform(d, Math::sin);

    var stringTransformUtils = new TransformUtils<String>();
    System.out.println(stringTransformUtils.transform(helloText, TransformUtils::exclaim));

    String suffix = "zhenya";

    // helloText.concat(suffix);
    System.out.println(stringTransformUtils.transform(suffix, helloText::concat));
  }

  public static <T extends Number> void processElements(List<T> intList, ElementProcessor function) {
    List<Double> doubleList = new ArrayList<>();
    for (Number i : intList) {
      doubleList.add(function.process(i));
    }

    System.out.println(doubleList);
  }

  private static int[] createRandomArray() {
    int[] myArray = new int[1000000];
    Random random = new Random();
    for (int i = 0; i < myArray.length; i++) {
      myArray[i] = random.nextInt(myArray.length);
    }
    return myArray;
  }

}
