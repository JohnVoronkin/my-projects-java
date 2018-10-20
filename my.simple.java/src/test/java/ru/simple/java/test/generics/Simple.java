package ru.simple.java.test.generic;

import java.util.ArrayList;
import java.util.List;

public class Simple {

  public static void main(String[] args) {
    List<Animal> listOfAnimal = new ArrayList<>();
    listOfAnimal.add(new Animal(1));
    listOfAnimal.add(new Animal(2));
    listOfAnimal.add(new Animal(3));

    List<Dog> listOfDog = new ArrayList<>();
    listOfDog.add(new Dog());
    listOfDog.add(new Dog());

    List<LiveView> listOfLiveView = new ArrayList<>();
    listOfLiveView.add(new LiveView());
    listOfLiveView.add(new LiveView());

    printAnimal_extends(listOfAnimal);
    printAnimal_extends(listOfDog);

    printAnimal_super(listOfLiveView);
    printAnimal_super(listOfAnimal);
  }

  private static void printAnimal_extends(List<? extends Animal> list) {
    for (Animal animal : list) {
      animal.eat();
    }
  }

  private static void printAnimal_super(List<? super Animal> list) {
    for (Object animal : list) {
      
    }
  }

}
