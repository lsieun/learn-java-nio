package lsieun.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class NIO_Path_Example_Resolve {
    public static void main(String[] args) throws Exception {
        Path p1 = Paths.get("C:\\Java_Dev");
        Path p2 = Paths.get("test1.txt");
        System.out.println(p1.resolve(p2));

        Path p3 = Paths.get("C:\\test.txt");
        System.out.println(p1.resolve(p3));

        Path p4 = Paths.get("");
        System.out.println(p1.resolve(p4));

        Path p5 = Paths.get("Java_Dev\\Test");
        Path p6 = Paths.get("test4.txt");
        System.out.println(p5.resolve(p6));
    }
}
