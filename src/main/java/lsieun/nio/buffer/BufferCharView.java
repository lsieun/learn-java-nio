package lsieun.nio.buffer;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;

public class BufferCharView {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(7).order(ByteOrder.LITTLE_ENDIAN);
        CharBuffer charBuffer = byteBuffer.asCharBuffer();

        // Load the ByteBuffer with some bytes
        byteBuffer.put(0, (byte) 0);
        byteBuffer.put(1, (byte) 'H');
        byteBuffer.put(2, (byte) 0);
        byteBuffer.put(3, (byte) 'i');
        byteBuffer.put(4, (byte) 0);
        byteBuffer.put(5, (byte) '!');
        byteBuffer.put(6, (byte) 0);

        print(byteBuffer);
        print(charBuffer);

        char[] charArray1 = new char[]{'H', 'i', '!'};
        char[] charArray2 = new char[]{(int)('H') * 16, 'i' * 16, '!' * 16};
        System.out.println(charArray1);
        System.out.println(charArray2);

        System.out.println(new String(charArray1));
        System.out.println(new String(charArray2));
    }

    // Print info about a buffer
    private static void print(Buffer buffer) {
        System.out.println("pos=" + buffer.position()
                + ", limit=" + buffer.limit()
                + ", capacity=" + buffer.capacity()
                + ": '" + buffer.toString() + "'");
    }
}