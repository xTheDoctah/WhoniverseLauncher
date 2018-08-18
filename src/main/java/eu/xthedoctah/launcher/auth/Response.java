package eu.xthedoctah.launcher.auth;

import eu.xthedoctah.launcher.utils.ToJson;

public class Response extends ToJson {
    private static Response istanza;
    private SelectedProfile selectedProfile;
    private String accessToken;
    private AvailableProfiles[] availableProfiles;
    private String clientToken;

    public static Response getInstance() {
        if (istanza == null) {
            istanza = new Response();
        }
        return istanza;
    }

    public static void setInstance(Response istanza2) {
        istanza = istanza2;
    }

    public SelectedProfile getSelectedProfile() {
        return selectedProfile;
    }

    public void setSelectedProfile(SelectedProfile selectedProfile) {
        this.selectedProfile = selectedProfile;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public AvailableProfiles[] getAvailableProfiles() {
        return availableProfiles;
    }

    public void setAvailableProfiles(AvailableProfiles[] availableProfiles) {
        this.availableProfiles = availableProfiles;
    }

    public String getClientToken() {
        return clientToken;
    }

    public void setClientToken(String clientToken) {
        this.clientToken = clientToken;
    }

}