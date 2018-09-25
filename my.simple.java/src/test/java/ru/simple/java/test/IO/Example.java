package ru.simple.java.test.IO;

import java.io.*;

public class Example {

  public static void main(String[] args) throws IOException {

    final ClassLoader classLoader = Example.class.getClassLoader();

    InputStream inStream = new FileInputStream(classLoader.getResource("IOFiles/InputStream.txt").getFile());
    OutputStream outStream = new FileOutputStream(classLoader.getResource("IOFiles/OutputStrem.txt").getFile());

    while (inStream.available() > 0) {
      int data = inStream.read(); //читаем один байт из потока для чтения
      outStream.write(data); //записываем прочитанный байт в другой поток.
    }

    inStream.close(); //закрываем потоки
    outStream.close();
  }

}
