package ru.simple.java.test.IO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {

  public void readFile(final String fileName) throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(fileName));
    String line;
    while ((line = reader.readLine()) != null) {
      System.out.println(line);
    }
  }

}
