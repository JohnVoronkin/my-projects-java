package ru.simple.java.test.IO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.simple.java.test.lists.map.treemap.SubjectGrade;

import java.io.Serializable;
import java.util.Set;

@AllArgsConstructor
@Getter
public class Student implements Serializable {

  private String name;
  private float averageGrade;
  private Set<SubjectGrade> grades;

}
