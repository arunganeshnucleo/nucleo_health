package com.prod.nucleohealth.data.model.response;

import com.google.gson.annotations.SerializedName;
import com.prod.nucleohealth.data.model.FamilyContact;
import com.prod.nucleohealth.data.model.UserDetails;

import java.util.ArrayList;

public class FamilyDetailsResponseModel {
    @SerializedName("status")
    String status;
    @SerializedName("message")
    String message;
    @SerializedName("data")
    ArrayList<FamilyContact> data;

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

    public ArrayList<FamilyContact> getData() {
        return data;
    }

    public void setData(ArrayList<FamilyContact> data) {
        this.data = data;
    }
}
