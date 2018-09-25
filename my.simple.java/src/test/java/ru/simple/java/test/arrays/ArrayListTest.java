package ru.simple.java.test.arrays;

import java.util.ArrayList;

public class ArrayListTest {

    public static void main(String[] args) {
        System.out.println(LIST);

        // create an empty array list with an initial capacity
        ArrayList<Integer> arrlist = new ArrayList<Integer>(5);

        // use add() method to add elements in the list
        arrlist.add(35);
        arrlist.add(20);
        arrlist.add(25);

        // Trim the arraylist
        arrlist.trimToSize();

        System.out.printf("В списке %s эл. \n", arrlist.size());
        // let us print all the elements available in list
        for (Integer number : arrlist) {
            System.out.println("Number = " + number);
        }

        System.out.println("Операция удаления:");
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.removeAll(list.subList(2, 5));
        list.trimToSize();
        System.out.println(list); //[1, 2, 6, 7, 8]
    }

    final static ArrayList<String> LIST = new ArrayList<String>() {
        {
            add("value one");
            add("value two");
            add("value there");
        }
    };


}
