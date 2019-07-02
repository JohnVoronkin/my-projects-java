package ru.simple.java.test.lists.map.treemap;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class SubjectGrade {

  private final String subject;
  private final int grade;

}
