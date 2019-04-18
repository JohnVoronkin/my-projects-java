package ru.simple.java.test.list.sample;

import java.util.ArrayList;
import java.util.List;

/*
 * List - это order collection (упорядоченная коллекция). Добавили в 3-й (в конец списка) индекс по списку, остается третьим и т.д.
 */
public class  ToDoList {

  private List<String> toDoList = new ArrayList<>();


  public void addToList(final String task) {
    toDoList.add(task);
  }

  public void addToListAtPosition(final int position, final String task) {
    toDoList.add(position, task);
  }

  public void printToDoList() {
    int count = 0;
    for (String task : toDoList) {
      System.out.println((count++) + " " + task);
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
