package lsieun.nio.channel;

import lsieun.utils.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class FileHole {
    public static void main(String[] args) throws IOException {
        String filepath = FileUtils.getFilePath("tmp.txt");
        File temp = new File(filepath);
        RandomAccessFile file = new RandomAccessFile(temp, "rw");
        FileChannel channel = file.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(100);
        putData(0, byteBuffer, channel);
        putData(5000000, byteBuffer, channel);
        putData(50000, byteBuffer, channel);

        System.out.println("Wrote temp file " + temp.getPath() + ", size=" + channel.size());
        channel.close();
        file.close();
    }

    private static void putData(int position, ByteBuffer buffer, FileChannel channel) throws IOException {
        String str = "*<-- location " + position;
        buffer.clear();
        buffer.put(str.getBytes(StandardCharsets.UTF_8));
        buffer.flip();

        channel.position(position);
        channel.write(buffer);
    }
}
