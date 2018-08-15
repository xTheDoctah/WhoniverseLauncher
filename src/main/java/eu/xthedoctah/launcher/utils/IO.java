package eu.xthedoctah.launcher.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class IO {
    public static void createDir(String dirPath) throws SecurityException {
        File file = new File(dirPath);
        if (!file.exists()) {
            file.mkdir();
        }
    }

    public static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
}
