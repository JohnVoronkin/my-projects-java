package ru.simple.java.test.NIO;

import java.io.IOException;

public class Launcher {

  public static final String FILE_NAME = "GradeBook.txt";

  public static void main(String[] args) {
    var fileUtils = new FileUtils();

    try {
      //fileUtils.printIOFileDetails(FILE_NAME);
      fileUtils.printIOFileDetails("./");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
