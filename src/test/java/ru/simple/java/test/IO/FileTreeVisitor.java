package ru.simple.java.test.IO;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FileTreeVisitor {

  public static void main(String[] args) throws IOException {
    Path path = Paths.get("temp");
    Files.walkFileTree(path, new Visitor());

  }

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


  public static class CopyFileVisitor extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
      return super.preVisitDirectory(dir, attrs);
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
      return super.visitFile(file, attrs);
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) {
      System.out.println("copy file faild " + file);
      return FileVisitResult.CONTINUE;
    }
  }


}
