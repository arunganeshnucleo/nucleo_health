package com.prod.nucleohealth.data.model;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("id")
    String id;
    @SerializedName("first_name")
    String firstName;
    @SerializedName("last_name")
    String lastName;
    @SerializedName("google_id")
    String googleId;
    @SerializedName("fb_id")
    String fbId;
    @SerializedName("email")
    String email;
    @SerializedName("phone_number")
    String phoneNumber;
    @SerializedName("email_verified_at")
    String emailVerifiedAt;
    @SerializedName("number_verified_at")
    String numberVerifiedAt;
    @SerializedName("is_active")
    String isActive;
    @SerializedName("user_type")
    String userType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGoogleId() {
        return googleId;
    }

    public void setGoogleId(String googleId) {
        this.googleId = googleId;
    }

    public String getFbId() {
        return fbId;
    }

    public void setFbId(String fbId) {
        this.fbId = fbId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailVerifiedAt() {
        return emailVerifiedAt;
    }

    public void setEmailVerifiedAt(String emailVerifiedAt) {
        this.emailVerifiedAt = emailVerifiedAt;
    }

    public String getNumberVerifiedAt() {
        return numberVerifiedAt;
    }

    public void setNumberVerifiedAt(String numberVerifiedAt) {
        this.numberVerifiedAt = numberVerifiedAt;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
