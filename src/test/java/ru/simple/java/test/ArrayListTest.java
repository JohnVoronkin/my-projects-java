package ru.simple.java.test;

import java.util.ArrayList;

public class ArrayListTest {

    public static void main(String[] args) {
        System.out.println(LIST);
    }

    final static ArrayList<String> LIST = new ArrayList<String>() {
        {
            add("value one");
            add("value two");
            add("value there");
        }
    };


}
