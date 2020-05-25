package com.prod.nucleohealth.data.model;

import com.google.gson.annotations.SerializedName;

public class FavoriteHospital {
    @SerializedName("businessId")
    String hospitalId;
    @SerializedName("business_name")
    String hospitalName;
    @SerializedName("expected_wait_time")
    String ewt;
    @SerializedName("Address")
    String address;
    @SerializedName("speciality_detail")
    String specialityDesc;

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getEwt() {
        return ewt;
    }

    public void setEwt(String ewt) {
        this.ewt = ewt;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSpecialityDesc() {
        return specialityDesc;
    }

    public void setSpecialityDesc(String specialityDesc) {
        this.specialityDesc = specialityDesc;
    }
}
