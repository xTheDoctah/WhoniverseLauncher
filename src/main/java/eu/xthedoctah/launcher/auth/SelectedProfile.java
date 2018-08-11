package eu.xthedoctah.launcher.auth;

import eu.xthedoctah.launcher.utils.ToJson;

public class SelectedProfile extends ToJson {
    private String id;

    private String paid;

    private String tokenId;

    private String legacyProfile;

    private String createdAt;

    private String userId;

    private String name;

    private String migrated;

    private String agent;

    private String suspended;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPaid() {
        return paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public String getLegacyProfile() {
        return legacyProfile;
    }

    public void setLegacyProfile(String legacyProfile) {
        this.legacyProfile = legacyProfile;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMigrated() {
        return migrated;
    }

    public void setMigrated(String migrated) {
        this.migrated = migrated;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getSuspended() {
        return suspended;
    }

    public void setSuspended(String suspended) {
        this.suspended = suspended;
    }

}