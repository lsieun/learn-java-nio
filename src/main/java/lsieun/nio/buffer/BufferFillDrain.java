package lsieun.nio.buffer;

import java.nio.CharBuffer;

public class BufferFillDrain {
    private static final String[] array = {
            "All human beings are born free and equal in dignity and rights.",
            "Everyone has the right to life, liberty and security of person.",
            "No one shall be held in slavery or servitude; slavery and the slave trade shall be prohibited in all their forms.",
            "No one shall be subjected to torture or to cruel, inhuman or degrading treatment or punishment.",
            "Everyone has the right to recognition everywhere as a person before the law.",
            "No one shall be subjected to arbitrary arrest, detention or exile.",
    };

    private static void fillBuffer(CharBuffer buffer, String str) {
        for (int i = 0; i < str.length(); i++) {
            buffer.put(str.charAt(i));
        }
    }

    private static void drainBuffer(CharBuffer buffer) {
        while (buffer.hasRemaining()) {
            System.out.print(buffer.get());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CharBuffer buffer = CharBuffer.allocate(120);

        for (String str : array) {
            fillBuffer(buffer, str);
            buffer.flip();
            drainBuffer(buffer);
            buffer.clear();
        }
    }
}
