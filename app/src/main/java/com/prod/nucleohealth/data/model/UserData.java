package com.prod.nucleohealth.data.model;

import com.google.gson.annotations.SerializedName;

public class UserData {
    @SerializedName("access_token")
    String accessToken;
    @SerializedName("token_type")
    String tokenType;
    @SerializedName("expires_in")
    String expiresIn;
    @SerializedName("user")
    User user;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
