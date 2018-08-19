package eu.xthedoctah.launcher.model;

import eu.xthedoctah.launcher.utils.ToJson;

public class Profile extends ToJson {
    private static Profile instance;
    private String username;
    private String password;
    private Boolean selected;

    public static Profile getInstance() {
        if (instance == null) {
            instance = new Profile();
        }
        return instance;
    }
    public static Profile setInstance(Profile profile){
        instance = profile;
        return instance;
    }

    public Profile(String username, String password, Boolean selected) {
        this.username = username;
        this.password = password;
        this.selected = selected;
    }

    public Profile() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }
}
