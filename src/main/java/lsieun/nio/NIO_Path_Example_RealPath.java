package lsieun.nio;

import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NIO_Path_Example_RealPath {
    public static void main(String[] args) throws IOException {
        Path p2 = Paths.get("link01");
        // Follow link for p2, if it is a symbolic link
        Path p2RealPath = p2.toRealPath();
        System.out.println("p2RealPath: " + p2RealPath);

        Path p3 = Paths.get("link02");
        // Do not follow link for p3, if it is a symbolic link
        Path p3RealPath = p3.toRealPath(LinkOption.NOFOLLOW_LINKS);
        System.out.println("p3RealPath: " + p3RealPath);
    }
}
