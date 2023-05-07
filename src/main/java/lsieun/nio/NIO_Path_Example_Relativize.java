package lsieun.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class NIO_Path_Example_Relativize {
    public static void main(String[] args) throws Exception {
        Path p1 = Paths.get("Java_Dev");
        Path p2 = Paths.get("Java_Dev", "recent", "Test");
        System.out.println(p1.relativize(p2));
        System.out.println(p2.relativize(p1));

        Path p3 = Paths.get("Abc");
        Path p4 = Paths.get("Def");
        System.out.println(p3.relativize(p4));
        System.out.println(p4.relativize(p3));
    }
}
