package IO;

import IO.NIO.FileUtils;
import lists.map.treemap.AverageStudentGrade;
import lists.map.treemap.SubjectGrade;
import lists.map.treemap.TreeMapLauncher;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;

public class Launcher {

  public static final String FILE_NAME = "GradeBook.txt";
  public static final String BUFFERED_FILE = "Buffered.bin";
  public static final String BINARY_FILE = "Student.bin";

  public static void main(String[] args) {
    Reader reader = new Reader();
    Writer writer = new Writer();
    SortedMap<AverageStudentGrade, Set<SubjectGrade>> grades = TreeMapLauncher.createGrades();

    writer.writeFile(grades, FILE_NAME);
    // reader.readFile(FILE_NAME);
    // writer.byteStream(FILE_NAME);

    //writer.writeWithFormatter();

    // processGrades(grades, writer, BINARY_FILE);
    // printObject(reader, BINARY_FILE);

    // reader.readFileInFull(FILE_NAME);
    // reader.nioReadFileWithBuffer(FILE_NAME);
    // writer.nioWriterWithBuffer(BUFFERED_FILE);
    // reader.nioReadWithStream(FILE_NAME);
    // writer.nioWriterWithStream(BUFFERED_FILE, "files recorded");
    // reader.nioReadWithChannel(FILE_NAME);
    // writer.nioWriteWithChannel(BUFFERED_FILE);
    // writer.writeWithRandomAccess(FILE_NAME);

    FileUtils utils = new FileUtils();
    utils.processDir();


  }

  private static void processGrades(SortedMap<AverageStudentGrade, Set<SubjectGrade>> grades, Writer writer,
                                    String fileName) {
    List<Student> students = new ArrayList<>();
    for (AverageStudentGrade gradeKey : grades.keySet()) {
      students.add(new Student(gradeKey.getName(), gradeKey.getAverageGrade(), grades.get(gradeKey)));
    }
    writer.writeObject(students, fileName);
  }

  private static void printObject(Reader reader, String fileName) {
    List<Student> students = reader.readObject(fileName);
    for (Student student : students) {
      System.out.printf("%s, %.2f %n", student.getName(), student.getAverageGrade());
      System.out.println(student.getGrades());
    }
  }


}
