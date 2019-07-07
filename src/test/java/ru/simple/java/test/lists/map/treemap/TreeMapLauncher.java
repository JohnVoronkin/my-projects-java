package ru.simple.java.test.lists.map.treemap;

import java.util.*;

public class TreeMapLauncher {

  public static void main(String[] args) {
    NavigableMap<AverageStudentGrade, Set<SubjectGrade>> grades = createGrades();
    printGrades(grades, false);

    AverageStudentGrade border = grades.ceilingKey(new AverageStudentGrade("", 82));
    NavigableMap<AverageStudentGrade, Set<SubjectGrade>> scholarshipStudents = (NavigableMap<AverageStudentGrade, Set<SubjectGrade>>) grades.tailMap(border);

    System.out.println("=== scholarship students ===");
    printGrades(scholarshipStudents.descendingMap(), false);

    System.out.println("Contender student");
    AverageStudentGrade contender = grades.lowerKey(border);
    System.out.println(contender);

    System.out.println("Highest grade student");
    System.out.println(scholarshipStudents.descendingMap().firstEntry());

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

    Set<SubjectGrade> simpsonGrade = new HashSet<>();
    simpsonGrade.add(new SubjectGrade("mathematics", 60));
    simpsonGrade.add(new SubjectGrade("history", 78));
    simpsonGrade.add(new SubjectGrade("literature", 70));

    NavigableMap<AverageStudentGrade, Set<SubjectGrade>> map = new TreeMap<>();
    map.put(new AverageStudentGrade("alex", calcAverage(alexGrade)), alexGrade);
    map.put(new AverageStudentGrade("victor", calcAverage(victorGrade)), victorGrade);
    map.put(new AverageStudentGrade("jonSnow", calcAverage(jonSnowGrade)), jonSnowGrade);
    map.put(new AverageStudentGrade("simpson", calcAverage(simpsonGrade)), simpsonGrade);

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
