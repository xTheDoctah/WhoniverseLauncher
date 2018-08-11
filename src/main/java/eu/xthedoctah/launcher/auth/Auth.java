package eu.xthedoctah.launcher.auth;

import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class Auth {
    private static Auth istanza;

    public static Auth getInstance() {
        if (istanza == null) {
            istanza = new Auth();
        }
        return istanza;
    }

    public boolean doAuth(String username, String password) {
        HttpClient httpClient = HttpClientBuilder.create().build();
        Gson gson = new Gson();
        User.getInstance().setPassword(password);
        User.getInstance().setUsername(username);
        try {
            HttpPost request = new HttpPost("https://authserver.mojang.com/authenticate");
            request.addHeader("Content-Type", "application/json");
            request.setEntity(new StringEntity(User.getInstance().toString()));
            HttpResponse response = httpClient.execute(request);
            String json = EntityUtils.toString(response.getEntity());
            if (json.contains("error")) {
                Error.setInstance(gson.fromJson(json, Error.class));
                return false;
            } else if (json.contains("accessToken")) {
                Response.setInstance(gson.fromJson(json, Response.class));
                return true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

        }

        return true;
    }
}
