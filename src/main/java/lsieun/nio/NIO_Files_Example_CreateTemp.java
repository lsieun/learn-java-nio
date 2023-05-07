package lsieun.nio;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NIO_Files_Example_CreateTemp {
    public static void main(String[] args) throws Exception {
        String dirPrefix = "KDir";
        Path tDir = Files.createTempDirectory(dirPrefix);
        System.out.println("Temp directory: " + tDir);

        String fPrefix = "Header_";
        String fSuffix = ".txt";
        Path tFile1 = Files.createTempFile(fPrefix, fSuffix);
        System.out.println("Temp file1: " + tFile1);

        Path p1 = Paths.get("C:\\temp");
        Path tFile2 = Files.createTempFile(p1, fPrefix, fSuffix);
        System.out.println("Temp file2: " + tFile2);
    }
}
