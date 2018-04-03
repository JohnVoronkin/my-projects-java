package ru.simple.java.test.string;


public class StringBufferTest {

    public static void main(String[] args) {
        StringBuilder contents = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            contents.append("hello world\n");
        }

        // вывод содержимого на экран
        System.out.println(contents.toString());
    }

}
