package ru.simple.java.test.IO;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.*;
import java.util.List;
import java.util.Set;

public class FileAttribute {

  public static void main(String[] args) throws IOException {
    Path path = Paths.get("temp");

    System.out.println("Size " + Files.size(path));
    System.out.println("Date modified " + Files.getLastModifiedTime(path));
    System.out.println("Is writable " + Files.isWritable(path));

    FileStore fs = Files.getFileStore(path);
    System.out.println("Type " + fs.type());


    // поддверживаемые типы FileAttributeView
    validateView(fs, BasicFileAttributeView.class); // поддерживается всеми ОС
    validateView(fs, DosFileAttributeView.class); // для ОС Win.
    validateView(fs, PosixFileAttributeView.class); // !Win, а для unix подобных систем
    validateView(fs, AclFileAttributeView.class); // позволяет управлять правами доступами для файлов и папок на platform Win.
    validateView(fs, UserDefinedFileAttributeView.class);
    validateView(fs, FileOwnerAttributeView.class);

    final PosixFileAttributes posixFileAttributes = Files.readAttributes(path, PosixFileAttributes.class);
    System.out.println("permissions " + posixFileAttributes.permissions());
    System.out.println("owner " + posixFileAttributes.owner());

    createFilePermission();

    UserPrincipal userPrincipal = path.getFileSystem().getUserPrincipalLookupService().lookupPrincipalByName("zhenay");
    AclFileAttributeView view = Files.getFileAttributeView(path, AclFileAttributeView.class);
    AclEntry aclEntry = AclEntry.newBuilder()
            .setType(AclEntryType.ALLOW)
            .setPrincipal(userPrincipal)
            .setPermissions(AclEntryPermission.READ_ATTRIBUTES, AclEntryPermission.READ_DATA).build();
    final List<AclEntry> acl = view.getAcl();
    acl.add(aclEntry);
    view.setAcl(acl);
  }


  //  создать файл и добавить ему соот. права доступа
  private static void createFilePermission() throws IOException {
    final Set<PosixFilePermission> posixFilePermissions = PosixFilePermissions.fromString("rwx------");
    // преобразовываем файловый Permissions
    final java.nio.file.attribute.FileAttribute<Set<PosixFilePermission>> setFileAttribute = PosixFilePermissions.asFileAttribute(posixFilePermissions);
    Files.createFile(Paths.get("file1.txt"), setFileAttribute);
  }

  private static void validateView(FileStore fs, Class<? extends FileAttributeView> viewClass) {
    final boolean supports = fs.supportsFileAttributeView(viewClass);
    System.out.println("supports " + viewClass.getSimpleName() + " - " + supports);
  }

}
