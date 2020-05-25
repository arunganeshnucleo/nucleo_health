package com.prod.nucleohealth.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {
    private Context context;
    private SharedPreferences sharedPreferences;


    public SessionManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("LOGIN", Context.MODE_PRIVATE);
    }


    public void saveLoginType(String s){
        sharedPreferences.edit().putString("loginType", s).commit();
    }

    public String getLoginType(){
        return sharedPreferences.getString("loginType", "");
    }

    public void saveUserType(String s){
        sharedPreferences.edit().putString("userType", s).commit();
    }

    public String getUserType(){
        return sharedPreferences.getString("userType", "");
    }
    public void saveUserName(String s){
        sharedPreferences.edit().putString("userName", s).commit();
    }

    public String getUserName() {
        return sharedPreferences.getString("userName", "");
    }

    public void savePassword(String s){
        sharedPreferences.edit().putString("password", s).commit();
    }

    public String getPassword() {
        return sharedPreferences.getString("password", "");
    }


    public void saveSessionToken(String sessionToken){
        sharedPreferences.edit().putString("sessionToken", sessionToken).commit();
    }


    public void saveFirstName(String firstName){
        sharedPreferences.edit().putString("firstName", firstName).commit();
    }

    public void saveLastName(String lastName){
        sharedPreferences.edit().putString("lastName", lastName).commit();
    }

    public void saveClientId(String clientId){
        sharedPreferences.edit().putString("clientId", clientId).commit();
    }
    public String getClientId(){
        return sharedPreferences.getString("clientId", "");
    }

    public String getSessionToken() {
        return sharedPreferences.getString("sessionToken", "");
    }
    public void setLoginStatus(Boolean isLoggedIn){
        sharedPreferences.edit().putBoolean("loggedIn", isLoggedIn).commit();
    }

    public Boolean getLoginStatus(){
        return sharedPreferences.getBoolean("loggedIn", false);
    }
    public void clearSession(){

        savePassword("");
        saveUserName("");
        saveSessionToken("");

        sharedPreferences.edit().clear().apply();
    }
}
