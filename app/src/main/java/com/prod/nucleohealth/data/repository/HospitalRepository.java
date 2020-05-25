package com.prod.nucleohealth.data.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.prod.nucleohealth.data.api.HospitalWebService;
import com.prod.nucleohealth.data.api.RetrofitRequest;
import com.prod.nucleohealth.data.model.request.HospitalsRequestModel;
import com.prod.nucleohealth.data.model.request.UserDetailsRequestModel;
import com.prod.nucleohealth.data.model.response.HospitalsResponseModel;
import com.prod.nucleohealth.data.model.response.SpecialityResponseModel;
import com.prod.nucleohealth.data.model.response.UserDetailsResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HospitalRepository {
    private static final String TAG = "HospitalRepository";
    private HospitalWebService webservice;
    public HospitalRepository() {
        Retrofit retrofitRequest = RetrofitRequest.getInstance();
        webservice = retrofitRequest.create(HospitalWebService.class);
    }

    public MutableLiveData getSpecialities(String applicationId, String accept) {
        MutableLiveData<SpecialityResponseModel> mutableLiveData = new MutableLiveData();
        Call<SpecialityResponseModel> call = webservice.getSpecialities(applicationId,accept);
        call.enqueue(new Callback<SpecialityResponseModel>() {
            @Override
            public void onResponse(Call<SpecialityResponseModel> call, Response<SpecialityResponseModel> response) {

                if (response.isSuccessful()) {
                    mutableLiveData.postValue(response.body());
                    Log.d(TAG, "onResponse: "+response.body());
                }
                else{
                    mutableLiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<SpecialityResponseModel> call, Throwable t) {
                mutableLiveData.postValue(null);
            }
        });
        return mutableLiveData;

    }

    public MutableLiveData getHospitals(String applicationId, String contentType, HospitalsRequestModel hospitalsRequestModel) {
        MutableLiveData<HospitalsResponseModel> mutableLiveData = new MutableLiveData();
        Call<HospitalsResponseModel> call = webservice.getHospitals(applicationId,contentType,hospitalsRequestModel);
        call.enqueue(new Callback<HospitalsResponseModel>() {
            @Override
            public void onResponse(Call<HospitalsResponseModel> call, Response<HospitalsResponseModel> response) {

                if (response.isSuccessful()) {
                    mutableLiveData.postValue(response.body());
                    Log.d(TAG, "onResponse: "+response.body());
                }
                else{
                    mutableLiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<HospitalsResponseModel> call, Throwable t) {
                mutableLiveData.postValue(null);
            }
        });
        return mutableLiveData;
    }
}
