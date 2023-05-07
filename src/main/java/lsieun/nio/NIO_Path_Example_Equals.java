package lsieun.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class NIO_Path_Example_Equals {
    public static void main(String[] args) throws Exception {
        Path p1 = Paths.get("C:\\Java_Dev\\test1.txt");
        Path p2 = Paths.get("C:\\Java_Dev\\LUCI1.TXT");
        Path p3 = Paths.get("C:\\Java_Dev\\..\\Java_Dev\\test1.txt");

        boolean b1 = p1.equals(p2);
        System.out.println(b1);

        boolean b2 = p1.equals(p3);
        System.out.println(b2);
    }
}
