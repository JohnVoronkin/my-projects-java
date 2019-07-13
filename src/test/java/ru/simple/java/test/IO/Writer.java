package ru.simple.java.test.IO;

import ru.simple.java.test.lists.map.treemap.AverageStudentGrade;
import ru.simple.java.test.lists.map.treemap.SubjectGrade;

import java.io.*;
import java.util.*;

public class Writer {

  public void byteStream(final String fileName) throws IOException {
    try (FileInputStream reader = new FileInputStream(fileName);
         FileOutputStream writer = new FileOutputStream("GradeBookByte.txt")) {
      int c;
      while ((c = reader.read()) != -1) {
        System.out.print(c);
        writer.write(c);
      }
    }
  }

  public void writeFile(SortedMap<AverageStudentGrade, Set<SubjectGrade>> grades, final String fileName) {
    // fileName - передаём название файла, куда будем записывать наши данные
    try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName))) {
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

  public void writeWithFormatter() throws IOException {
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

  public void writeObject(List<Student> students, String fileName) {

  }

}
