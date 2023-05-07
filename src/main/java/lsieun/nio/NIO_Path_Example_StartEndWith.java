package lsieun.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class NIO_Path_Example_StartEndWith {
    public static void main(String[] args) throws Exception {
        Path p1 = Paths.get("C:\\Java_Dev\\test1.txt");
        Path p2 = Paths.get("test1.txt");
        Path p3 = Paths.get("Java_Dev\\test1.txt");
        Path p4 = Paths.get(".txt");

        // Using endsWith()
        boolean b1 = p1.endsWith(p2);
        System.out.println(b1);
        boolean b2 = p1.endsWith(p3);
        System.out.println(b2);
        boolean b3 = p1.endsWith(p4);
        System.out.println(b3);

        // Using startsWith()
        Path p5 = Paths.get("C:\\");
        Path p6 = Paths.get("C:\\Java_Dev");
        Path p7 = Paths.get("C:\\Java_Dev\\test");

        boolean b4 = p1.startsWith(p5);
        System.out.println(b4);
        boolean b5 = p1.startsWith(p6);
        System.out.println(b5);
        boolean b6 = p1.startsWith(p7);
        System.out.println(b6);
    }
}
