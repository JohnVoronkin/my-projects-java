package ru.simple.java.test.simple.methodOverridingPartTwo;

public class methodOverridingPartTwo {

  public static void main(String[] args) {

    Cat parent = new Cat();
    Cat me = new Cat();
    me.setMyParent(parent);
    Cat myParent = me.getMyParent();

  }











}
