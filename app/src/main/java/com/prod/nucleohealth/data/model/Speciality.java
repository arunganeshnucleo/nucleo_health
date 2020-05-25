package com.prod.nucleohealth.data.model;

import com.google.gson.annotations.SerializedName;

public class Speciality {
    @SerializedName("id")
    String id;
    @SerializedName("name")
    String name;
    @SerializedName("image_url")
    String imgUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
