package eu.xthedoctah.launcher.settings;


import com.google.gson.Gson;
import eu.xthedoctah.launcher.logger.LogType;
import eu.xthedoctah.launcher.logger.Logger;
import eu.xthedoctah.launcher.model.Profile;
import eu.xthedoctah.launcher.utils.IO;
import org.json.JSONArray;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Settings {
    private static String workingDir = System.getProperty("user.home") + "/.whoniverse";
    public static String logsPath = Settings.workingDir + "/logs/";
    private static String userProfiles = workingDir + "/profiles.json";
    private static String settingsFile = workingDir + "/settings.json";
    private static Settings instance;

    public static Settings getInstance() {
        if (instance == null) {
            instance = new Settings();
        }
        return instance;
    }

    public void onInit() {
        try {
            IO.createDir(workingDir);
            IO.createDir(logsPath);
            IO.createFileIfNotExist(userProfiles);
            IO.createFileIfNotExist(settingsFile);
            if (Settings.getInstance().readUsers().size() > 0) {
                Settings.getInstance().readUsers().forEach(item -> {
                    if (item.getSelected())
                        Profile.setInstance(item);
                });
            }
        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        } finally {
            Logger.getInstance().createLog(LogType.INFO, "OS: " +
                    System.getProperty("os.name") +
                    System.getProperty("os.arch") +
                    System.getProperty("os.version"));
        }
    }

    private List<Profile> readUsers() {
        ArrayList<Profile> profileArrayList = new ArrayList<Profile>();
        try {
            if (IO.isEmpty(userProfiles)) {
                return profileArrayList;
            } else {
                String json = IO.readFile(userProfiles, StandardCharsets.UTF_8);
                JSONArray arr = new JSONArray(json);
                arr.forEach(item -> {
                    profileArrayList.add(new Gson().fromJson(item.toString(), Profile.class));
                });
                return profileArrayList;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void createUser(Profile user) {
        try {
            List<Profile> profiles = this.readUsers();
            profiles.add(user);
            IO.writeFile(userProfiles, new Gson().toJson(profiles));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
