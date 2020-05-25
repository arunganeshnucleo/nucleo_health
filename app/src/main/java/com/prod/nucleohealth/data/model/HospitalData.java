package com.prod.nucleohealth.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class HospitalData {
    @SerializedName("hospital_details")
    ArrayList<HospitalDetails> hospitalDetails;

    public ArrayList<HospitalDetails> getHospitalDetails() {
        return hospitalDetails;
    }

    public void setHospitalDetails(ArrayList<HospitalDetails> hospitalDetails) {
        this.hospitalDetails = hospitalDetails;
    }
}
