package ru.simple.java.test.IO;

import ru.simple.java.test.lists.map.treemap.AverageStudentGrade;
import ru.simple.java.test.lists.map.treemap.SubjectGrade;
import ru.simple.java.test.lists.map.treemap.TreeMapLauncher;

import java.io.*;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.NavigableMap;
import java.util.Set;

public class IOLauncher {

  public static final String FILE_NAME = "GradeBook.txt";

  public static void main(String[] args) throws IOException {
    NavigableMap<AverageStudentGrade, Set<SubjectGrade>> grades = TreeMapLauncher.createGrades();

    /*writeFile(grades);
    readFile();
    byteStream();*/

    Formatter formatter = new Formatter("BankAccounts.txt");
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    System.out.println("please enter clientId, client name, client surname, account balance");
    int i = 0;
    while (i < 2) {
      try {
        formatter.format("%d, %s, %s, %.2f", Integer.valueOf(reader.readLine()), reader.readLine(), reader.readLine(),
                Float.valueOf(reader.readLine()));
        i++;
      } catch (InputMismatchException e) {
        System.out.println("Input is incorrect. Please thy again");
        e.printStackTrace();
        reader.readLine();
      }
      formatter.close();
    }

  }

  private static void byteStream() throws IOException {
    try (FileInputStream reader = new FileInputStream(FILE_NAME);
         FileOutputStream writer = new FileOutputStream("GradeBookByte.txt")) {
      int c;
      while ((c = reader.read()) != -1) {
        System.out.print(c);
        writer.write(c);
      }
    }
  }

  private static void readFile() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
    String line;
    while ((line = reader.readLine()) != null) {
      System.out.println(line);
    }
  }

  private static void writeFile(NavigableMap<AverageStudentGrade, Set<SubjectGrade>> grades) {
    // fileName - передаём название файла, куда будем записывать наши данные
    try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(FILE_NAME))) {
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
