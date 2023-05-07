package lsieun.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class NIO_Path_Example_Normalize {
    public static void main(String[] args) throws Exception {
        Path p1 = Paths.get("C:\\Java_Dev\\..\\\\Java_Dev\\test1.txt");
        Path p1n = p1.normalize();
        System.out.println(p1 + "  normalized to " + p1n);

        Path p2 = Paths.get("C:\\Java_Dev\\test1.txt");
        Path p2n = p2.normalize();
        System.out.println(p2 + "  normalized to " + p2n);

        Path p3 = Paths.get("\\..\\.\\test.txt");
        Path p3n = p3.normalize();
        System.out.println(p3 + "  normalized to " + p3n);
    }
}
