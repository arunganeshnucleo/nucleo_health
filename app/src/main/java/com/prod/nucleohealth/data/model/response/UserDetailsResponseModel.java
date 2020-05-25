package com.prod.nucleohealth.data.model.response;

import com.google.gson.annotations.SerializedName;
import com.prod.nucleohealth.data.model.UserData;
import com.prod.nucleohealth.data.model.UserDetails;

public class UserDetailsResponseModel {
    @SerializedName("status")
    String status;
    @SerializedName("message")
    String message;
    @SerializedName("data")
    UserDetails data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserDetails getData() {
        return data;
    }

    public void setData(UserDetails data) {
        this.data = data;
    }
}
