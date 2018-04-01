package ru.simple.java.test.simple;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MyTest {
    public static void main(String[] args) {
        System.out.println(Arrays.stream(new String[]{"a", "b", "c"})
                .collect(Collectors.joining(",")));

        System.out.println(max(1,9));
        System.out.println(max(3,2));


    }

    private static int max(int arg1, int arg2){
        if(arg1 < arg2) return arg1;
        return arg2;

    }

}
