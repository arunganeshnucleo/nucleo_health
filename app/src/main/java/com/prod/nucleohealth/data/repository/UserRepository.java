package com.prod.nucleohealth.data.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.prod.nucleohealth.data.api.RetrofitRequest;
import com.prod.nucleohealth.data.api.UserAccountWebService;
import com.prod.nucleohealth.data.model.request.FamilyDetailsRequestModel;
import com.prod.nucleohealth.data.model.request.LoginRequestModel;
import com.prod.nucleohealth.data.model.request.UserDetailsRequestModel;
import com.prod.nucleohealth.data.model.response.FamilyDetailsResponseModel;
import com.prod.nucleohealth.data.model.response.LoginResponseModel;
import com.prod.nucleohealth.data.model.response.UserDetailsResponseModel;
import com.prod.nucleohealth.utils.Constants;
import com.prod.nucleohealth.utils.SessionManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class UserRepository {
    private static final String TAG = "UserRepository";
    private UserAccountWebService webservice;
    public UserRepository() {
        Retrofit retrofitRequest = RetrofitRequest.getInstance();
        webservice = retrofitRequest.create(UserAccountWebService.class);
    }

    public MutableLiveData loginUser(LoginRequestModel loginRequestModel) {
        MutableLiveData<LoginResponseModel> mutableLiveData = new MutableLiveData();
        Call<LoginResponseModel> call = webservice.loginUser(Constants.ACCEPT_HEADER,Constants.APPLICATION_ID,Constants.CONTENT_TYPE,loginRequestModel);

        call.enqueue(new Callback<LoginResponseModel>() {
            @Override
            public void onResponse(Call<LoginResponseModel> call, Response<LoginResponseModel> response) {
                Log.d(TAG, "onResponse: "+loginRequestModel);
                if (response.isSuccessful()) {
                    mutableLiveData.postValue(response.body());
                    Log.d(TAG, "onResponse: "+response.body());
                }
                else{
                    mutableLiveData.postValue(response.body());
                }

            }

            @Override
            public void onFailure(Call<LoginResponseModel> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.getMessage());
                mutableLiveData.postValue(null);
            }


        });
        return mutableLiveData;

    }
    public MutableLiveData getUserDetailsByClientId(String acceptHeader, String authToken,UserDetailsRequestModel userDetailsRequestModel) {
        MutableLiveData<UserDetailsResponseModel> mutableLiveData = new MutableLiveData();
        Call<UserDetailsResponseModel> call = webservice.getUserDetailsByClientId(acceptHeader, authToken,userDetailsRequestModel);
        call.enqueue(new Callback<UserDetailsResponseModel>() {
            @Override
            public void onResponse(Call<UserDetailsResponseModel> call, Response<UserDetailsResponseModel> response) {

                if (response.isSuccessful()) {
                    mutableLiveData.postValue(response.body());
                    Log.d(TAG, "onResponse: "+response.body());
                }
                else{
                    mutableLiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<UserDetailsResponseModel> call, Throwable t) {
                mutableLiveData.postValue(null);
            }
        });
        return mutableLiveData;

    }
    public MutableLiveData getFamilyDetailsByClientId(String acceptHeader, String authToken, FamilyDetailsRequestModel familyDetailsRequestModel) {
        MutableLiveData<FamilyDetailsResponseModel> mutableLiveData = new MutableLiveData();
        Call<FamilyDetailsResponseModel> call = webservice.getUserFamilyList(acceptHeader,authToken,familyDetailsRequestModel);
        call.enqueue(new Callback<FamilyDetailsResponseModel>() {
            @Override
            public void onResponse(Call<FamilyDetailsResponseModel> call, Response<FamilyDetailsResponseModel> response) {

                if (response.isSuccessful()) {
                    mutableLiveData.postValue(response.body());
                    Log.d(TAG, "onResponse: "+response.body());
                }
                else{
                    mutableLiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<FamilyDetailsResponseModel> call, Throwable t) {
                mutableLiveData.postValue(null);
            }
        });
        return mutableLiveData;

    }
}
