package Person;


import java.util.ArrayList;
import java.util.Collections;

public class Person {

    private ArrayList<Actor> actors;
    private String name;
    private Integer age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
        actors = new ArrayList<>();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s - %d", this.getName(), this.getAge());
    }


}
