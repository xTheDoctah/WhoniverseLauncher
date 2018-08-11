package eu.xthedoctah.launcher.auth;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class Auth {
    public boolean doAuth() {
        HttpClient httpClient = HttpClientBuilder.create().build();
        User user = new User();
        try {

            HttpPost request = new HttpPost("https://authserver.mojang.com/authenticate");
            StringEntity params = new StringEntity(user.toString());
            request.addHeader("Content-Type", "application/json");
            request.setEntity(params);
            HttpResponse response = httpClient.execute(request);
            String json = EntityUtils.toString(response.getEntity());
            System.out.println(json);

        } catch (Exception ex) {

            ex.printStackTrace();

        } finally {

        }
        System.out.println(user.toString());
        return true;
    }
}
