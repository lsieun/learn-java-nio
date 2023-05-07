package lsieun.nio;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NIO_Files_Example_SymbolicLink {
    public static void main(String[] args) throws Exception {
        Path existingFilePath = Paths.get("D:\\tmp\\test1.txt");
        Path symLinkPath = Paths.get("D:\\test1_link.txt");
        Files.createSymbolicLink(symLinkPath, existingFilePath);
    }
}
