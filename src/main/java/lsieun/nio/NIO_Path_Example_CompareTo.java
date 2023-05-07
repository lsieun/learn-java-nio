package lsieun.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class NIO_Path_Example_CompareTo {
    public static void main(String[] args) throws Exception {
        Path p1 = Paths.get("C:\\Java_Dev\\test1.txt");
        Path p2 = Paths.get("C:\\Java_Dev\\Test1.txt");
        Path p3 = Paths.get("C:\\Java_Dev\\..\\Java_Dev\\test1.txt");

        int v1 = p1.compareTo(p2);
        System.out.println(v1);

        int v2 = p1.compareTo(p3);
        System.out.println(v2);
    }
}
