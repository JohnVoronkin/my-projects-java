package java_example.collections.lambda.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
public class Person {

  private String name;
  private String lastName;
  private int age;

}
