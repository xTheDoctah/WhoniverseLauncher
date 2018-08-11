package eu.xthedoctah.launcher.auth;

import eu.xthedoctah.launcher.utils.ToJson;

public class Agent extends ToJson {
    private String name = "Minecraft";
    private int version = 1;

    public Agent(String name, int version) {
        this.name = name;
        this.version = version;
    }

    public Agent() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }


}
