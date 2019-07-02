package ru.simple.java.test.lists.map.treemap;

import java.util.*;

public class TreeMapLauncher {

  public static void main(String[] args) {

    NavigableMap<AverageStudentGrade, Set<SubjectGrade>> grades = createGrades();
    printGrades(grades, false);

  }

  private static void printGrades(Map<AverageStudentGrade, Set<SubjectGrade>> grades, boolean printValue) {
    Set<AverageStudentGrade> averageStudentGrades = grades.keySet();
    for (AverageStudentGrade gr : averageStudentGrades) {
      System.out.println(gr);
      if (printValue) {
        Set<SubjectGrade> subjectGrades = grades.get(gr);
        for (SubjectGrade subjectGrade: subjectGrades)
        System.out.println(subjectGrade);
      }
      System.out.println();
    }
  }

  private static NavigableMap<AverageStudentGrade, Set<SubjectGrade>> createGrades() {

    Set<SubjectGrade> alexGrade = new HashSet<>();
    alexGrade.add(new SubjectGrade("mathematics", 89));
    alexGrade.add(new SubjectGrade("history", 95));
    alexGrade.add(new SubjectGrade("literature", 78));

    Set<SubjectGrade> victorGrade = new HashSet<>();
    victorGrade.add(new SubjectGrade("mathematics", 78));
    victorGrade.add(new SubjectGrade("history", 67));
    victorGrade.add(new SubjectGrade("literature", 50));

    Set<SubjectGrade> jonSnowGrade = new HashSet<>();
    jonSnowGrade.add(new SubjectGrade("mathematics", 98));
    jonSnowGrade.add(new SubjectGrade("history", 90));
    jonSnowGrade.add(new SubjectGrade("literature", 83));

    NavigableMap<AverageStudentGrade, Set<SubjectGrade>> map = new TreeMap<>();
    map.put(new AverageStudentGrade("alex", calcAverage(alexGrade)), alexGrade);
    map.put(new AverageStudentGrade("victor", calcAverage(victorGrade)), victorGrade);
    map.put(new AverageStudentGrade("jonSnow", calcAverage(jonSnowGrade)), jonSnowGrade);

    return map;
  }

  private static float calcAverage(Set<SubjectGrade> gradeSet) {
    float sum = 0;
    for (SubjectGrade grade : gradeSet) {
      sum += grade.getGrade();
    }
    return sum / gradeSet.size();
  }
}
