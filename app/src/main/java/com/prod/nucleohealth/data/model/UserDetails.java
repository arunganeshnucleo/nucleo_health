package com.prod.nucleohealth.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class UserDetails {
    @SerializedName("id")
    String id;
    @SerializedName("user_id")
    String userId;
    @SerializedName("first_name")
    String firstName;
    @SerializedName("last_name")
    String lastName;
    @SerializedName("phone_number")
    String phoneNumber;
    @SerializedName("avator")
    String avatarLink;
    @SerializedName("email")
    String email;
    @SerializedName("address1")
    String address1;
    @SerializedName("address2")
    String address2;
    @SerializedName("city")
    String city;
    @SerializedName("country")
    String country;
    @SerializedName("state")
    String state;
    @SerializedName("zip_code")
    String zipCode;
    @SerializedName("date_of_birth")
    String dob;
    @SerializedName("marital_status")
    String maritalStatus;
    @SerializedName("nationality")
    String nationality;
    @SerializedName("language")
    String language;
    @SerializedName("gender")
    String gender;
    @SerializedName("blood_group")
    String bloodGroup;

    @SerializedName("emergency_contact")
    EmergencyContact emergencyContact;
    @SerializedName("age")
    String age;
    @SerializedName("family_count")
    int familyCount;
    @SerializedName("favourite_business_count")
    int favoriteHospitalCount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAvatarLink() {
        return avatarLink;
    }

    public void setAvatarLink(String avatarLink) {
        this.avatarLink = avatarLink;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }


    public EmergencyContact getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(EmergencyContact emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getFamilyCount() {
        return familyCount;
    }

    public void setFamilyCount(int familyCount) {
        this.familyCount = familyCount;
    }

    public int getFavoriteHospitalCount() {
        return favoriteHospitalCount;
    }

    public void setFavoriteHospitalCount(int favoriteHospitalCount) {
        this.favoriteHospitalCount = favoriteHospitalCount;
    }
}
