package com.prod.nucleohealth.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class HospitalDetails {
   @SerializedName("id")
    private long id;
    @SerializedName("user_id")
    private String userId;



    @SerializedName("business_name")
    private String hospitalName;
    @SerializedName("fax_number")
    private String faxNumber;
    @SerializedName("avator")
    private String avatorImage;



    @SerializedName("address1")
    private String address1;
    @SerializedName("address2")
    private String address2;
    @SerializedName("city")
    private String city;
    @SerializedName("state")
    private String state;
    @SerializedName("country")
    private String country;
    @SerializedName("zip_code")
    private String zipCode;
    @SerializedName("geo_location")
    private String geoLocation;
    @SerializedName("working_hours")
    private String workingHours;
    @SerializedName("working_days")
    private String workingDays;

    @SerializedName("phone_number")
    private String phoneNumber;
    @SerializedName("expected_wait_time")
    private String ewt;
    @SerializedName("email")
    private String email;
    @SerializedName("latitude")
    private String latitude;
    @SerializedName("longitude")
    private String longitude;
    @SerializedName("speciality")
    private String speciality;
    @SerializedName("facility")
    private String facility;
    @SerializedName("year_of_build")
    private String yearOfBuild;
    @SerializedName("profile_summary")
    private String summary;
    @SerializedName("capacity")
    private String capacity;
    @SerializedName("google_loc_id")
    private  String googleLocId;
    @SerializedName("user_unique_id")
    private String hospitalUniqueId;
    @SerializedName("speciality_detail")
    private ArrayList<Speciality> specialityDetail;
    @SerializedName("distance")
    private int distance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getAvatorImage() {
        return avatorImage;
    }

    public void setAvatorImage(String avatorImage) {
        this.avatorImage = avatorImage;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(String geoLocation) {
        this.geoLocation = geoLocation;
    }

   public String getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(String workingHours) {
        this.workingHours = workingHours;
    }

     public String getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(String workingDays) {
        this.workingDays = workingDays;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEwt() {
        return ewt;
    }

    public void setEwt(String ewt) {
        this.ewt = ewt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }

    public String getYearOfBuild() {
        return yearOfBuild;
    }

    public void setYearOfBuild(String yearOfBuild) {
        this.yearOfBuild = yearOfBuild;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getGoogleLocId() {
        return googleLocId;
    }

    public void setGoogleLocId(String googleLocId) {
        this.googleLocId = googleLocId;
    }

    public String getHospitalUniqueId() {
        return hospitalUniqueId;
    }

    public void setHospitalUniqueId(String hospitalUniqueId) {
        this.hospitalUniqueId = hospitalUniqueId;
    }

    public ArrayList<Speciality> getSpecialityDetail() {
        return specialityDetail;
    }

    public void setSpecialityDetail(ArrayList specialityDetail) {
        this.specialityDetail = specialityDetail;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
