package java_example.IO;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FileTreeVisitor {

  public static void main(String[] args) throws IOException {
    Path path = Paths.get("temp");
    // Files.walkFileTree(path, new Visitor());

    Files.walkFileTree(path, new CopyFileVisitor(path, Paths.get("temp2" + File.separator + "copy")));

  }

  // рекурсивное переименование файлов / директорий
  public static class Visitor extends SimpleFileVisitor<Path> {

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
      renameTree(file);
      return FileVisitResult.CONTINUE;
    }

    private void renameTree(Path file) throws IOException {
      // сколько вложенных директорий имеется в пути
      int nameCount = file.getNameCount();

      if (nameCount > 1) {
        Path startPath = file.subpath(0, nameCount - 1);
        Path endPath = file.subpath(nameCount - 1, nameCount);

        Files.move(file, Paths.get(startPath + File.separator +
                LocalDate.now().format(DateTimeFormatter.ISO_DATE) + "_" + endPath));
      }
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
      return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
      renameTree(dir);
      return FileVisitResult.CONTINUE;
    }
  }
  
  // рекурсивное копирование файлов
  public static class CopyFileVisitor extends SimpleFileVisitor<Path> {

    Path source, destination;

    public CopyFileVisitor(Path source, Path destination) {
      this.source = source; // начальный путь из к-го начиначется копирование
      this.destination = destination;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes attrs) {
      try {
        copy(path);
      } catch (IOException e) {
        System.err.println("copy dir error " + path);
        e.printStackTrace();
        return FileVisitResult.SKIP_SIBLINGS;
      }
      return FileVisitResult.CONTINUE;
    }

    private void copy(Path path) throws IOException {
      // relativize() - метод позволяет получить относительный путь нашей dir
      Path relative = source.relativize(path);
      System.out.println("relative path " + relative);
      final Path destinationPath = destination.resolve(relative);
      System.out.println("destination path " + destinationPath);

      Files.copy(path, destinationPath);
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
      return super.visitFile(file, attrs);
    }

    @Override
    public FileVisitResult visitFileFailed(Path path, IOException exc) {
      try {
        copy(path);
      } catch (IOException e) {
        System.err.println("copy file error " + path);
      }
      return FileVisitResult.CONTINUE;
    }
  }


}
