package ru.simple.java.test.NIO;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;

public class FileUtils {

  public void printIOFileDetails(String path) throws IOException {
    File file = new File(path);
    // get path details
    // абсолютный путь
    System.out.println("absolute path - " + file.getAbsolutePath());
    // относительный путь
    System.out.println("relative path - " + file.getPath());
    System.out.println("free space in MBytes - " + file.getFreeSpace() / 1000000);
    // получить родительскую директорию файла
    System.out.println("parent directory - " + file.getParent());
    System.out.println("is absolute - " + file.isAbsolute());
    System.out.println("current directory is - " + System.getProperty("user.dir"));

    // является ли данный объект директорией или же он является файлом?
    if (file.isDirectory()) {
      System.out.println("It is a dir.. Printing content:");
      String[] list = file.list();
      if (list != null) {
        for (String el : list)
          System.out.println(el);
      }

    } else {
      System.out.println("It is a file ");
      // если такого файла нет - создаем файл
      System.out.println("Creating a new file - " + file.createNewFile());
      // permissions
      System.out.println("can read - " + file.canRead());
      System.out.println("can write - " + file.canWrite());
      System.out.println("can exe - " + file.canExecute());
      System.out.println("file is hidden - " + file.isHidden());
      System.out.println("last modified - " + file.lastModified());
      System.out.println("deleting a file - " + file.delete());

      Path filePath = file.toPath(); // получить объект path (путь) из нашего файла

      BufferedInputStream br = new BufferedInputStream(new FileInputStream(file));
    }

  }
}
