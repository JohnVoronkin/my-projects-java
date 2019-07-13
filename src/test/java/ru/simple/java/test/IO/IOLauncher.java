package ru.simple.java.test.IO;

import ru.simple.java.test.lists.map.treemap.AverageStudentGrade;
import ru.simple.java.test.lists.map.treemap.SubjectGrade;
import ru.simple.java.test.lists.map.treemap.TreeMapLauncher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;

public class IOLauncher {

  public static final String FILE_NAME = "GradeBook.txt";

  public static void main(String[] args) throws IOException {
    Reader reader = new Reader();
    Writer writer = new Writer();
    SortedMap<AverageStudentGrade, Set<SubjectGrade>> grades = TreeMapLauncher.createGrades();

    writer.writeFile(grades, FILE_NAME);
    reader.readFile(FILE_NAME);
    writer.byteStream(FILE_NAME);

    writer.writeWithFormatter();

  }

  private void processGrades(SortedMap<AverageStudentGrade, Set<SubjectGrade>> grades, Writer writer, String fileName) {
    List<Student> students = new ArrayList<>();
    for (AverageStudentGrade gradeKey : grades.keySet()) {
      students.add(new Student(gradeKey.getName(), gradeKey.getAverageGrade(), grades.get(gradeKey)));
    }

    writer.writeObject(students, fileName);
  }


}
