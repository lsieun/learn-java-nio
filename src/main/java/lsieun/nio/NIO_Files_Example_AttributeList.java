package lsieun.nio;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class NIO_Files_Example_AttributeList {
    public static void main(String[] args) throws Exception {
        Path path = Paths.get("D:\\tmp\\test\\abc.txt");

        // Prepare the attribute list
        String attribList = "basic:size,lastModifiedTime";

        // Read the attributes
        Map<String, Object> attribs = Files.readAttributes(path, attribList);

        System.out.format("Size:%s, Last Modified Time: %s %n",
                attribs.get("size"), attribs.get("lastModifiedTime"));

    }
}
