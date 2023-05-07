package lsieun.nio.buffer;

import lsieun.utils.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MappedByteBufferReadFile {
    public static void main(String[] args) throws IOException {
        // reading a file with memoryMapping
        String filepath = FileUtils.getFilePath("sample.txt");
        File file = new File(filepath);

        FileInputStream fis = new FileInputStream(file);

        FileChannel fc = fis.getChannel();

        MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, file.length());

        // bb.flip();  // not needed

        int limit = bb.limit(); // bytes in buffer
        for (int i = 0; i < limit; i++) {
            byte b = bb.get(i);
            System.out.print((char) b);
        }
    }
}
