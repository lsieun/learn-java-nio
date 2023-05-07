package lsieun.nio;

import java.io.IOException;
import java.nio.file.*;

public class NIO_Files_Example_Delete {
    public static void main(String[] args) throws Exception {
        Path p = Paths.get("C:\\Java_Dev\\test1.txt");

        try {
            Files.delete(p);
            System.out.println(p + " deleted successfully.");
        } catch (NoSuchFileException e) {
            System.out.println(p + " does not exist.");
        } catch (DirectoryNotEmptyException e) {
            System.out.println("Directory " + p + " is not empty.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
