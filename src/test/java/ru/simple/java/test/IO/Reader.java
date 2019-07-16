package ru.simple.java.test.IO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Reader {

  public void readFile(final String fileName) throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(fileName));
    String line;
    while ((line = reader.readLine()) != null) {
      System.out.println(line);
    }
  }

  public List<Student> readObject(String fileName) {
    List<Student> students = new ArrayList<>();
    try (ObjectInputStream input = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))) {
      boolean keepReading = true;
      while (keepReading) {
        Student student = (Student) input.readObject();
        if (!"".equals(student.getName()))
          students.add(student);
        else keepReading = false;
      }
    } catch (IOException | ClassNotFoundException e) {
      System.out.println("Unable to open file " + fileName + ". Program terminates");
      e.printStackTrace();
    }
    return students;
  }

}
