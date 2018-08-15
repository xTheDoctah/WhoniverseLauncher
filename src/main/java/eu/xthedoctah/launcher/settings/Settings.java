package eu.xthedoctah.launcher.settings;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import eu.xthedoctah.launcher.auth.User;
import eu.xthedoctah.launcher.logger.LogType;
import eu.xthedoctah.launcher.model.Profile;
import eu.xthedoctah.launcher.utils.IO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Settings {
    public static String workingDir = System.getProperty("user.home") + "\\.whoniverse";
    public static String userProfiles = workingDir + "\\profiles.json";

    public static void onInit() {
        //TODO: Parser the json string ?
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(userProfiles, true));
            List<String> lista  = new ArrayList<>();
            lista.add(new Profile("ciao","did",false).toString());
            lista.add(new Profile("ciaof","difd",true).toString());
            String js = new Gson().toJson(lista);
            writer.write(js);
            System.out.println(js);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String usersListJson = IO.readFile(userProfiles, StandardCharsets.UTF_8);
            List<String> profiles = new ObjectMapper().readValue(usersListJson, List.class);
            System.out.println(profiles.get(1));
            for (String st : profiles){
                //populate array with st converted to OBJECT
            }

            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void createUser(User user) {
        //TODO:Read array and put element if there is no one there.

    }
}
