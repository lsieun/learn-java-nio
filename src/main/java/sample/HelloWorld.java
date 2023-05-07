package sample;

import lsieun.utils.BufferUtils;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.StandardCharsets;

public class HelloWorld {
    public static void main(String[] args) throws IOException {

    }

    public static void testMarkAndReset() {
        ByteBuffer buffer = ByteBuffer.allocate(10); // mark = -1, position = 0
        buffer.position(2);                          // mark = -1, position = 2
        buffer.mark();                               // mark = 2,  position = 2
        buffer.position(5);                          // mark = 2,  position = 5
        buffer.reset();                              // mark = 2,  position = 2
    }

    public static void testPutItself() {
        ByteBuffer buffer = ByteBuffer.allocate(10); // mark = -1, position = 0
        buffer.put(buffer);
    }

    public static void testIntBuffer() {
        byte[] bytes = new byte[]{
                (byte) 0xCA, (byte) 0xFE, (byte) 0xBA, (byte) 0xBE, // CAFEBABE ---> cafe babe
                (byte) 0xF0, (byte) 0x07, (byte) 0xBA, (byte) 0x11, // F007BA11 ---> football
                (byte) 0x0F, (byte) 0xF1, (byte) 0xCE               // 0FF1CE   ---> office
        };
        ByteBuffer buffer = ByteBuffer.wrap(bytes);

        IntBuffer intBuffer = buffer.asIntBuffer();
        int capacity = intBuffer.capacity();                         // 2

        System.out.println(capacity);
    }

    public static void testDirect() {
        ByteBuffer buffer = ByteBuffer.allocateDirect(10);
        isXxx(buffer);
    }

    public static void testReadOnly() {
        byte[] bytes = new byte[]{
                (byte) 0xCA, (byte) 0xFE, (byte) 0xBA, (byte) 0xBE, // CAFEBABE ---> cafe babe
                (byte) 0xF0, (byte) 0x07, (byte) 0xBA, (byte) 0x11, // F007BA11 ---> football
                (byte) 0x0F, (byte) 0xF1, (byte) 0xCE               // 0FF1CE   ---> office
        };
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        ByteBuffer view = buffer.asReadOnlyBuffer();

        isXxx(view);
    }

    public static void testView() {
        byte[] bytes = new byte[]{
                (byte) 0xCA, (byte) 0xFE, (byte) 0xBA, (byte) 0xBE, // CAFEBABE ---> cafe babe
                (byte) 0xF0, (byte) 0x07, (byte) 0xBA, (byte) 0x11, // F007BA11 ---> football
                (byte) 0x0F, (byte) 0xF1, (byte) 0xCE               // 0FF1CE   ---> office
        };
        ByteBuffer buffer = ByteBuffer.wrap(bytes);

        IntBuffer intBuffer = buffer.asIntBuffer();
        isXxx(intBuffer);
    }

    public static void isXxx(Buffer buffer) {
        boolean isDirect = buffer.isDirect();
        boolean isReadOnly = buffer.isReadOnly();
        boolean hasArray = buffer.hasArray();
        System.out.println("isDirect: " + isDirect);
        System.out.println("isReadOnly: " + isReadOnly);
        System.out.println("hasArray: " + hasArray);
    }

    public static void testByteOrder() {
        byte[] bytes = new byte[]{(byte) 0xCA, (byte) 0xFE, (byte) 0xBA, (byte) 0xBE};
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        int val = buffer.getInt();

        System.out.println(val);
        System.out.println(Integer.toHexString(val));
    }
}
