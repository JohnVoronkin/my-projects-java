package ru.simple.java.test.lists.sample;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/*
 * List - это order collection (упорядоченная коллекция).
 * Добавили в 3-й (в конец списка) индекс по списку, остается третьим и т.д.
 */
public class ToDoList {

  private LinkedList<String> toDoList = new LinkedList<>();


  public void addToList(final String task) {
    addAlphabeticalOrder(task);
  }

  private boolean addAlphabeticalOrder(final String task) {
    ListIterator<String> listIterator = toDoList.listIterator();
    while (listIterator.hasNext()) {
      int compared = listIterator.next().compareTo(task);
      if (compared == 0) {
        System.out.println("Task already exists in the lists");
        return true;
      } else if (compared > 0) {
        listIterator.previous();
        listIterator.add(task);
        return true;
      }
    }
    toDoList.add(task);
    return true;
  }

  public void addToListAtPosition(final int position, final String task) {
    toDoList.add(position, task);
  }

  public void printToDoList() {
    int count = 0;
    Iterator<String> iterator = toDoList.iterator();
    while (iterator.hasNext()) { // пока возвращает true - можно выполнять какое-то действие в цикле
      System.out.println("element " + (count++) + " " + iterator.next());
    }
  }

  public void changeTask(final int index, final String task) {
    // set - позволяет перезаписать элемент в списке
    toDoList.set(index, task);
  }

  public void removeTask(final String task) {
    toDoList.remove(task);
  }

  public int getTaskPriority(final String task) {
    // indexOf - получить индекс элемента списка
    return toDoList.indexOf(task);
  }


}
