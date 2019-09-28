package IO.NIO;

import java.io.IOException;

public class Launcher {

  public static final String FILE_NAME = "GradeBook.txt";

  public static void main(String[] args) {
    FileUtils fileUtils = new FileUtils();

    try {
      //fileUtils.printIOFileDetails(FILE_NAME);
      fileUtils.printIOFileDetails("./");
      System.out.println("---");
      fileUtils.printNioFileDetails(FILE_NAME);
      fileUtils.createDir(FILE_NAME);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
