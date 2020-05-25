package com.prod.nucleohealth.data.model.response;

import com.google.gson.annotations.SerializedName;
import com.prod.nucleohealth.data.model.Speciality;
import com.prod.nucleohealth.data.model.UserData;

import java.util.ArrayList;

public class SpecialityResponseModel {
    @SerializedName("status")
    String status;
    @SerializedName("message")
    String message;
    @SerializedName("data")
    ArrayList<Speciality> data;

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

    public ArrayList<Speciality> getData() {
        return data;
    }

    public void setData(ArrayList<Speciality> data) {
        this.data = data;
    }
}
