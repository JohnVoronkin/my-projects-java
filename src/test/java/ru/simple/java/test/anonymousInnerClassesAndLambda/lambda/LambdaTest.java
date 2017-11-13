package ru.simple.java.test.anonymousInnerClassesAndLambda.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class LambdaTest {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 5, 67, 12);

        numbers.forEach(System.out::println);
        System.out.println("\nсумма чётных чисел: " + sumAll(numbers, n -> n % 2 == 0));
    }

    private static int sumAll(List<Integer> numbers, Predicate<Integer> p) {
        int total = 0;
        for (int number : numbers) {
            if (p.test(number)) {
                total += number;
            }
        }
        return total;
    }


}
