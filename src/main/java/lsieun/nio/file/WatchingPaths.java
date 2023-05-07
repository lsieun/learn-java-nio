package lsieun.nio.file;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

import static java.nio.file.StandardWatchEventKinds.*;

public class WatchingPaths {
    public static void main(String[] args) throws IOException, InterruptedException {
        FileSystem fs = FileSystems.getDefault();
        Path watchPath = fs.getPath("D:\\git-repo\\learn-java-nio\\");
        WatchService watchService = fs.newWatchService();
        watchPath.register(watchService, ENTRY_CREATE, ENTRY_MODIFY, ENTRY_DELETE);

        WatchKey changeKey;
        while ((changeKey = watchService.take()) != null) {
            // Prevent receiving two separate ENTRY_MODIFY events: file modified and timestamp updated.
            // Instead, receive one ENTRY_MODIFY event with two counts.
            Thread.sleep( 50 );

            List<WatchEvent<?>> watchEvents = changeKey.pollEvents();
            for (WatchEvent<?> watchEvent : watchEvents) {
                // Ours are all Path type events:
                WatchEvent<Path> pathEvent = (WatchEvent<Path>) watchEvent;

                Path path = pathEvent.context();
                WatchEvent.Kind<Path> eventKind = pathEvent.kind();
                System.out.println(eventKind + " for path: " + path);
            }
            changeKey.reset(); // Important!
        }
    }
}
