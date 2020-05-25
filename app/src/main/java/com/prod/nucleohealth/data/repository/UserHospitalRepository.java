package com.prod.nucleohealth.data.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.prod.nucleohealth.data.api.RetrofitRequest;
import com.prod.nucleohealth.data.api.UserHospitalWebService;
import com.prod.nucleohealth.data.model.request.FavoriteHospitalRequestModel;
import com.prod.nucleohealth.data.model.request.LoginRequestModel;
import com.prod.nucleohealth.data.model.response.FavoriteHosptitalResponseModel;
import com.prod.nucleohealth.data.model.response.LoginResponseModel;
import com.prod.nucleohealth.utils.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class UserHospitalRepository {
    private static final String TAG = "UserHospitalRepository";
    UserHospitalWebService webService;

    public UserHospitalRepository() {
        Retrofit retrofitRequest = RetrofitRequest.getInstance();
        webService = retrofitRequest.create(UserHospitalWebService.class);
    }

    public MutableLiveData getFavoriteHospitals(FavoriteHospitalRequestModel favoriteHospitalRequestModel) {
        MutableLiveData<FavoriteHosptitalResponseModel> mutableLiveData = new MutableLiveData();
        Call<FavoriteHosptitalResponseModel> call = webService.getFavoriteHospitals(Constants.ACCEPT_HEADER,Constants.APPLICATION_ID,favoriteHospitalRequestModel);
        call.enqueue(new Callback<FavoriteHosptitalResponseModel>() {
            @Override
            public void onResponse(Call<FavoriteHosptitalResponseModel> call, Response<FavoriteHosptitalResponseModel> response) {

                if (response.isSuccessful()) {
                    mutableLiveData.postValue(response.body());
                    Log.d(TAG, "onResponse: "+response.body());
                }
                else{
                    mutableLiveData.postValue(response.body());
                }

            }

            @Override
            public void onFailure(Call<FavoriteHosptitalResponseModel> call, Throwable t) {
                mutableLiveData.postValue(null);
            }


        });
        return mutableLiveData;

    }
}
