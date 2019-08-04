package ru.simple.java.test.IO;

import ru.simple.java.test.lists.map.treemap.AverageStudentGrade;
import ru.simple.java.test.lists.map.treemap.SubjectGrade;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

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
    try (ObjectOutputStream output = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)))) {
      for (Student student : students) {
        output.writeObject(student);
      }
      output.writeObject(new Student("", -1, null));
    } catch (IOException e) {
      System.out.println("File cannot be opened. Program terminates");
      e.printStackTrace();
    }
  }

  public void nioWriterWithBuffer(String fileName) throws IOException {
    Path path = Paths.get(fileName);
    Charset charset = StandardCharsets.UTF_8;
    try (BufferedWriter writer = Files.newBufferedWriter(path, charset)) {
      // offset 0 - отступ от начала нашего буфера и далее указываем до какой степени будем писать
      writer.write(fileName, 0, fileName.length()); // length() - пока есть символы
    }
  }

  public void nioWriterWithStream(String filename, String lines) {
    Path path = Paths.get(filename);
    byte[] bytes = lines.getBytes();
    try (OutputStream stream = Files.newOutputStream(path, CREATE, APPEND)) {
      stream.write(bytes, 0, bytes.length);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
