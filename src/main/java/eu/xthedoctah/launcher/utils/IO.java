package eu.xthedoctah.launcher.utils;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class IO {
    public static Boolean createDir(String dirPath) throws SecurityException {
        File file = new File(dirPath);
        if (!file.exists()) {
            return file.mkdir();
        }
        return true;
    }

    public static Boolean createFileIfNotExist(String filePath) throws IOException {
        if (!new File(filePath).exists()) {
            return new File(filePath).createNewFile();
        }
        return true;
    }

    public static void writeFile(String path, String text) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        writer.write(text);
        writer.close();
    }

    public static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    public static Boolean isEmpty(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        return (reader.readLine() == null);

    }
}
