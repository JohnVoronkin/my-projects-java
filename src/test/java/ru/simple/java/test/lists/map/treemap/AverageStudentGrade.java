package ru.simple.java.test.lists.map.treemap;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class AverageStudentGrade implements Comparable<AverageStudentGrade> {

  private final String name;
  private final float averageGrade;

  @Override
  public int compareTo(AverageStudentGrade that) {
    if (this.averageGrade < that.getAverageGrade())
      return -1;
    if (this.averageGrade > that.getAverageGrade())
      return 1;

    return that.name.compareTo(that.getName());
  }
}
