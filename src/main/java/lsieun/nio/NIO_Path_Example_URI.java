package lsieun.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class NIO_Path_Example_URI {
    public static void main(String[] args) throws Exception {
        Path p2 = Paths.get("test2.txt");
        java.net.URI p2UriPath = p2.toUri();
        System.out.println("Absolute Path: " + p2.toAbsolutePath());
        System.out.println("URI Path: " + p2UriPath);
    }
}
