package IO;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
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

  /**
   * Чтение данных из файла
   *
   * @param fileName имя передаваемого файла
   * @throws IOException
   */
  public void readFileInFull(String fileName) throws IOException {
    Path path = Paths.get(fileName);
    var lines = Files.readAllLines(path);
    for (String item : lines) {
      System.out.println(item);
    }
  }

  public void nioReadFileWithBuffer(String fileName) throws IOException {
    Path path = Paths.get(fileName);
    // если файл не в стандартной кодировке
    Charset charset = StandardCharsets.UTF_8;
    try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
      String line;
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
      }
    }
  }

  public void nioReadWithStream(String filename) {
    Path path = Paths.get(filename);
    try (InputStream in = Files.newInputStream(path)) {
      BufferedReader reader = new BufferedReader(new InputStreamReader(in));
      String line;
      while ((line = reader.readLine()) != null)
        System.out.println(line);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void nioReadWithChannel(String fileName) {
    /*// чтение данных
    FileInputStream inputStream = new FileInputStream(fileName);
    inputStream.getChannel();
    // запись данных
    FileOutputStream outputStream = new FileOutputStream(fileName);
    outputStream.getChannel();*/

    // создаем channel - к-й работает в обе стороны, т.е. как на read (input) так и на write (output)
    try (RandomAccessFile rw = new RandomAccessFile(fileName, "rw");
         FileChannel channel = rw.getChannel()) {
      ByteBuffer buffer = ByteBuffer.allocate(100); // capacity буфера

      int bytesNumber = channel.read(buffer);
      while (bytesNumber > 0) {
        buffer.flip();
        while (buffer.hasRemaining()) {
          System.out.print((char) buffer.get());
        }
        buffer.clear();
        bytesNumber = channel.read(buffer);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
