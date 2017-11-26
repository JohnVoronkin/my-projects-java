package ru.simple.java.test;


public class StringBufferTest {

    public static void main(String[] args) {
        StringBuffer contents = new StringBuffer();
        for (int i = 0; i < 100; i++) {
            contents.append("hello world\n");
        }

        // вывод содержимого на экран
        System.out.println(contents.toString());
    }

}
