package domain.person;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;

@Setter
@Getter
public class Person {

  private ArrayList<Actor> actors;
  private String name;
  private int age;

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public Person() {
    this.actors = new ArrayList<>();
  }

  public Person addActor(Actor... actors) {
    Collections.addAll(this.actors, actors);
    return this;
  }

  public Person act() {
    for (Actor actor : actors) {
      actor.act();
    }
    return this;
  }

  @Override
  public String toString() {
    return String.format("%s - %d", this.getName(), this.getAge());
  }


}
