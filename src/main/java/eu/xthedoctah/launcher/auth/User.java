package eu.xthedoctah.launcher.auth;

import eu.xthedoctah.launcher.utils.ToJson;

import java.util.UUID;

public class User extends ToJson {
    /*Signleton*/
    private static User istanza;
    private Agent agent;
    private String username;
    private String password;
    private String clientToken;
    private Boolean requestUser = false;

    public User() {
        this.agent = new Agent();
        this.clientToken = UUID.randomUUID().toString();
    }

    public User(String username, String password, String clientToken, Boolean requestUser) {
        this.agent = new Agent();
        this.username = username;
        this.password = password;
        this.clientToken = clientToken;
        this.requestUser = requestUser;
    }

    public static User getInstance() {
        if (istanza == null) {
            istanza = new User();
        }
        return istanza;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
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

    public String getClientToken() {
        return clientToken;
    }

    public void setClientToken(String clientToken) {
        this.clientToken = clientToken;
    }

    public Boolean getRequestUser() {
        return requestUser;
    }

    public void setRequestUser(Boolean requestUser) {
        this.requestUser = requestUser;
    }
}
