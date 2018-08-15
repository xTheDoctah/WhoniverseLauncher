package eu.xthedoctah.launcher.utils;

import java.io.File;

public class IO {
    public static void createDir(String dirPath) throws SecurityException {
        File file = new File(dirPath);
        if (!file.exists()) {
            file.mkdir();
        }
    }
}
