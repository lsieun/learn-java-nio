package lsieun.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NIO_Path_Example_IsSameFile {
    public static void main(String[] args) {
        // Assume that D:\tmp\test\abc.txt file exists
        Path p1 = Paths.get("D:\\tmp\\test\\abc.txt");
        Path p2 = Paths.get("D:\\tmp\\..\\tmp\\test\\abc.txt");

        // Assume that D:\abc.txt file does not exist
        Path p3 = Paths.get("D:\\abc.txt");
        Path p4 = Paths.get("D:\\abc.txt");

        try {
            boolean isSame = Files.isSameFile(p1, p2);
            System.out.println("p1 and  p2  are   the   same:  " + isSame);

            isSame = Files.isSameFile(p3, p4);
            System.out.println("p3 and  p4  are   the   same:  " + isSame);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
