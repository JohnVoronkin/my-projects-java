package ru.simple.java.test.IO;

import ru.simple.java.test.lists.map.treemap.AverageStudentGrade;
import ru.simple.java.test.lists.map.treemap.SubjectGrade;
import ru.simple.java.test.lists.map.treemap.TreeMapLauncher;

import java.io.*;
import java.util.NavigableMap;
import java.util.Set;

public class IOLauncher {

  public static final String FILE_NAME = "GradeBook.txt";

  public static void main(String[] args) throws IOException {
    NavigableMap<AverageStudentGrade, Set<SubjectGrade>> grades = TreeMapLauncher.createGrades();

    readFile(grades);

    readFile();
  }

  private static void readFile() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
    String line;
    while ((line = reader.readLine()) != null) {
      System.out.println(line);
    }
  }

  private static void readFile(NavigableMap<AverageStudentGrade, Set<SubjectGrade>> grades) {
    try (PrintWriter fileWriter = new PrintWriter(new FileWriter(FILE_NAME))) {
      // fileName - передаём название файла, куда будем записывать наши данные
      for (AverageStudentGrade grade : grades.keySet()) {
        // читаем данные из Map и записываем их в файл
        fileWriter.write("student: " + grade.getName() + " average grade: " + grade.getAverageGrade() + "\n");
        for (SubjectGrade subjectGrade : grades.get(grade)) {
          fileWriter.write("subject: " + subjectGrade.getSubject() + "grade: " + subjectGrade.getGrade() + "\n");
        }
        fileWriter.write("\n");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
