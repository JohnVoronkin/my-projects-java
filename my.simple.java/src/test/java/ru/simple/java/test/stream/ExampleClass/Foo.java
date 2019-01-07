package ru.simple.java.test.stream.ExampleClass;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class Foo {

  private String name;
  List<Bar> bars = new ArrayList<>();

  public Foo(String name) {
    this.name = name;
  }

}
