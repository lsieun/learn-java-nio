package lsieun.nio;

import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardCopyOption.COPY_ATTRIBUTES;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class NIO_Files_Example_Copy {
    public static void main(String[] args) {
        Path source = Paths.get("C:\\Java_Dev\\test1.txt");
        Path target = Paths.get("C:\\Java_Dev\\test1_backup.txt");

        try {
            Path p = Files.copy(source, target, REPLACE_EXISTING, COPY_ATTRIBUTES);
            System.out.println(source + " has been copied to " + p);
        } catch (FileAlreadyExistsException e) {
            System.out.println(target + " already exists.");
        } catch (DirectoryNotEmptyException e) {
            System.out.println(target + " is not empty.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
