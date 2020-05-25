package com.prod.nucleohealth.data.model.response;

import com.google.gson.annotations.SerializedName;
import com.prod.nucleohealth.data.model.HospitalData;
import com.prod.nucleohealth.data.model.HospitalDetails;
import com.prod.nucleohealth.data.model.UserData;

import java.util.ArrayList;

public class HospitalsResponseModel {
    @SerializedName("status")
    String status;
    @SerializedName("message")
    String message;
    @SerializedName("data")
    HospitalData data;



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

    public HospitalData getData() {
        return data;
    }

    public void setData(HospitalData data) {
        this.data = data;
    }
}
