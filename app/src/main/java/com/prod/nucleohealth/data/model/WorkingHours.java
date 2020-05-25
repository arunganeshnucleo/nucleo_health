package com.prod.nucleohealth.data.model;

import com.google.gson.annotations.SerializedName;

public class WorkingHours {
    @SerializedName("morning_open_at")
    String morningOpenAt;
    @SerializedName("morning_close_at")
    String morningCloseAt;
    @SerializedName("evening_open_at")
    String eveningOpenAt;
    @SerializedName("evening_close_at")
    String eveningCloseAt;

    public String getMorningOpenAt() {
        return morningOpenAt;
    }

    public void setMorningOpenAt(String morningOpenAt) {
        this.morningOpenAt = morningOpenAt;
    }

    public String getMorningCloseAt() {
        return morningCloseAt;
    }

    public void setMorningCloseAt(String morningCloseAt) {
        this.morningCloseAt = morningCloseAt;
    }

    public String getEveningOpenAt() {
        return eveningOpenAt;
    }

    public void setEveningOpenAt(String eveningOpenAt) {
        this.eveningOpenAt = eveningOpenAt;
    }

    public String getEveningCloseAt() {
        return eveningCloseAt;
    }

    public void setEveningCloseAt(String eveningCloseAt) {
        this.eveningCloseAt = eveningCloseAt;
    }
}
