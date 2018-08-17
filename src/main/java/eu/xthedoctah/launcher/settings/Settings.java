package eu.xthedoctah.launcher.settings;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import eu.xthedoctah.launcher.logger.LogType;
import eu.xthedoctah.launcher.logger.Logger;
import eu.xthedoctah.launcher.model.Profile;
import eu.xthedoctah.launcher.utils.IO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Settings {
    public static String workingDir = System.getProperty("user.home") + "/.whoniverse";
    private static String userProfiles = workingDir + "/profiles.json";
    private static String settingsFile = workingDir + "/settings.json";
    public static String logsPath = Settings.workingDir + "/logs/";
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

        } catch (SecurityException |IOException e) {
            e.printStackTrace();
        } finally {
            Logger.getInstance().createLog(LogType.INFO, "OS: " +
                    System.getProperty("os.name") +
                    System.getProperty("os.arch") +
                    System.getProperty("os.version"));
        }
    }

    private List<Profile> readUsers() {
        String listJson;
        List<Profile> profileList;
        try {
            listJson = IO.readFile(userProfiles, StandardCharsets.UTF_8);
            if (!listJson.equals("")) {
                profileList = new ArrayList<Profile>();
                List<String> profilesString = new ObjectMapper().readValue(listJson, List.class);
                profilesString.forEach(item -> {
                    profileList.add(new Gson().fromJson(item, Profile.class));
                    System.out.println(new Gson().fromJson(item, Profile.class));
                });
                return profileList;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public void createUser(Profile user) {
        try {
            if (this.readUsers() == null) {
                BufferedWriter writer = new BufferedWriter(new FileWriter(userProfiles));
                writer.write(new Gson().toJson((this.readUsers().add(user))));
                writer.close();
            } else {
                BufferedWriter writer = new BufferedWriter(new FileWriter(userProfiles));
                writer.write(new Gson().toJson((new ArrayList<Profile>().add(user))));
                writer.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();

        }

    }
}
