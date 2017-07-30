package ru.simple.java.test;

import java.io.IOException;

public class ArrayTest {

    public static void main(String[] args) throws IOException {

        minArray();
        sumElementArrays();

    }

    private static void minArray() {
        int[] list = {5, 6, 7, 8, 1, 2, 5, -7, -9, 2, 0};

        int min = list[0];
        for (int i = 1; i < list.length; i++) {
            if (list[i] < min)
                min = list[i];
        }

        System.out.println("Min is " + min + "\n");
    }

    private static void sumElementArrays(){
        //это статическая инициализация
        int[] list = {5, 6, 7, 8, 1, 2, 5, -7, -9, 2, 0};

        //подсчёт суммы элементов
        int sum = 0;
        for (int i = 0; i < list.length; i++)
            sum += list[i];

        System.out.println("Sum is " + sum + "\n");
    }
}
