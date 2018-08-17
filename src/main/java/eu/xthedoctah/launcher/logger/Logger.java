package eu.xthedoctah.launcher.logger;

import eu.xthedoctah.launcher.settings.Settings;
import eu.xthedoctah.launcher.utils.IO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    private static Logger instance;
    private String dateFormat = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    private String timeFormat = new SimpleDateFormat("HH-mm-ss").format(new Date()) + ".log";



    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }

        return instance;
    }

    public void log(String logType, Object log) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(Settings.logsPath  + dateFormat + "/" + timeFormat, true));
            writer.newLine();
            writer.write(logType + " " + log);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void createLog(String logType, String log) {
        try {
            IO.createDir(Settings.logsPath + dateFormat);
            BufferedWriter writer = new BufferedWriter(new FileWriter(Settings.logsPath  + dateFormat + "/" + timeFormat));
            writer.write(logType + " " + log);
            writer.close();
        } catch (IOException ioex) {
            ioex.printStackTrace();
        } catch (SecurityException sex) {
            sex.printStackTrace();
        }
    }
}
