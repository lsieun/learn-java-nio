package lsieun.nio;

import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFileAttributeView;

public class NIO_FileStore_Example_SupportedFileAttributeView {
    public static void main(String[] args) throws Exception {
        Path path = Paths.get("");
        FileStore fs = Files.getFileStore(path);

        // Check if POSIX file attribute is supported by the file store
        boolean supported = fs.supportsFileAttributeView(PosixFileAttributeView.class);
        if (supported) {
            System.out.println("POSIX file attribute view is supported.");
        }
        else {
            System.out.println("POSIX file attribute view is not supported.");
        }

    }
}
