package ru.simple.java.test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MyTest {
    public static void main(String[] args) {
        System.out.println(Arrays.stream(new String[]{"a", "b", "c"})
                .collect(Collectors.joining(",")));
    }
}
