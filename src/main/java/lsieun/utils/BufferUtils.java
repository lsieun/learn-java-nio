package lsieun.utils;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Formatter;

public class BufferUtils {
    public static void print(ByteBuffer buffer) {
        int count = buffer.remaining();
        byte[] bytes = new byte[count];

        buffer.duplicate().get(bytes);

        String str = Arrays.toString(bytes);
        System.out.println(str);
    }

    public static void printIndex(Buffer buffer) {
        StringBuilder sb = new StringBuilder();
        Formatter fm = new Formatter(sb);
        fm.format("mark: %-8d ", getMark(buffer));
        fm.format("position: %-8d ", buffer.position());
        fm.format("limit: %-8d ", buffer.limit());
        fm.format("capacity: %-8d ", buffer.capacity());
        if (buffer.hasArray()) {
            fm.format("offset: %-8d ", buffer.arrayOffset());
            fm.format("length: %-8d ", Array.getLength(buffer.array()));
        }
        System.out.println(sb);
    }

    private static int getMark(Buffer buffer) {
        try {
            Class<?> clazz = Buffer.class;
            Field f = clazz.getDeclaredField("mark");
            f.setAccessible(true);
            Object result = f.get(buffer);
            return (int) result;
        }
        catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static String toString(ByteBuffer bb) {
        final byte[] bytes = new byte[bb.remaining()];

        bb.duplicate().get(bytes);

        return new String(bytes);
    }

    // region Unsigned
    public static short getUnsignedByte(ByteBuffer bb) {
        return ((short) (bb.get() & 0xff));
    }

    public static void putUnsignedByte(ByteBuffer bb, int value) {
        bb.put((byte) (value & 0xff));
    }

    public static short getUnsignedByte(ByteBuffer bb, int position) {
        return ((short) (bb.get(position) & (short) 0xff));
    }

    public static void putUnsignedByte(ByteBuffer bb, int position, int value) {
        bb.put(position, (byte) (value & 0xff));
    }

    // ---------------------------------------------------------------

    public static int getUnsignedShort(ByteBuffer bb) {
        return (bb.getShort() & 0xffff);
    }

    public static void putUnsignedShort(ByteBuffer bb, int value) {
        bb.putShort((short) (value & 0xffff));
    }

    public static int getUnsignedShort(ByteBuffer bb, int position) {
        return (bb.getShort(position) & 0xffff);
    }

    public static void putUnsignedShort(ByteBuffer bb, int position, int value) {
        bb.putShort(position, (short) (value & 0xffff));
    }

    // ---------------------------------------------------------------

    public static long getUnsignedInt(ByteBuffer bb) {
        return ((long) bb.getInt() & 0xffffffffL);
    }

    public static void putUnsignedInt(ByteBuffer bb, long value) {
        bb.putInt((int) (value & 0xffffffffL));
    }

    public static long getUnsignedInt(ByteBuffer bb, int position) {
        return ((long) bb.getInt(position) & 0xffffffffL);
    }

    public static void putUnsignedInt(ByteBuffer bb, int position, long value) {
        bb.putInt(position, (int) (value & 0xffffffffL));
    }
    // endregion
}
