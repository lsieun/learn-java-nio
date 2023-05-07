package lsieun.nio;

import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardCopyOption.ATOMIC_MOVE;

public class NIO_Files_Example_Move {
    public static void main(String[] args) {
        Path source = Paths.get("C:\\Java_Dev\\test1.txt");
        Path target = Paths.get("C:\\Java_Dev\\dir2\\test1.txt");

        try {
            Path p = Files.move(source, target, ATOMIC_MOVE);
            System.out.println(source + " has been moved to " + p);
        } catch (NoSuchFileException e) {
            System.out.println("Source/target does not exist.");
        } catch (FileAlreadyExistsException e) {
            System.out.println(target + " already exists. Move failed.");
        } catch (DirectoryNotEmptyException e) {
            System.out.println(target + " is not empty. Move failed.");
        } catch (AtomicMoveNotSupportedException e) {
            System.out.println("Atomic move is not supported. Move failed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
