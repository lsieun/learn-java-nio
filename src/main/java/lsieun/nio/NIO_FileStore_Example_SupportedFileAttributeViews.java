package lsieun.nio;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.*;

public class NIO_FileStore_Example_SupportedFileAttributeViews {
    public static void main(String[] args) {
        Path path = Paths.get("C:");

        try {
            FileStore fs = Files.getFileStore(path);
            printDetails(fs, AclFileAttributeView.class);
            printDetails(fs, BasicFileAttributeView.class);
            printDetails(fs, DosFileAttributeView.class);
            printDetails(fs, FileOwnerAttributeView.class);
            printDetails(fs, PosixFileAttributeView.class);
            printDetails(fs, UserDefinedFileAttributeView.class);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void printDetails(FileStore fs, Class<? extends FileAttributeView> attribClass) {
        boolean supported = fs.supportsFileAttributeView(attribClass);
        System.out.format("%s is supported: %s%n", attribClass.getSimpleName(), supported);
    }
}
