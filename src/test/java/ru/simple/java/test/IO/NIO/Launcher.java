package ru.simple.java.test.IO.NIO;

import java.io.IOException;

public class Launcher {

  public static final String FILE_NAME = "GradeBook.txt";

  public static void main(String[] args) {
    FileUtils fileUtils = new FileUtils();

    try {
      //fileUtils.printIOFileDetails(FILE_NAME);
      fileUtils.printIOFileDetails("./");
      fileUtils.printNioFileDetails(FILE_NAME);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
