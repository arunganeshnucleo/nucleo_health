package com.prod.nucleohealth.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.prod.nucleohealth.data.model.request.HospitalsRequestModel;
import com.prod.nucleohealth.data.model.response.HospitalsResponseModel;
import com.prod.nucleohealth.data.model.response.SpecialityResponseModel;
import com.prod.nucleohealth.data.repository.HospitalRepository;

public class HospitalMapViewModel extends AndroidViewModel {
    private LiveData<HospitalsResponseModel> data;
    private HospitalRepository hospitalRepository;
    private HospitalsRequestModel hospitalsRequestModel;
    private String applicationId;
    private String contentType;

    public HospitalMapViewModel(@NonNull Application application) {
        super(application);
        hospitalRepository = new HospitalRepository();
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public HospitalsRequestModel getHospitalsRequestModel() {
        return hospitalsRequestModel;
    }

    public void setHospitalsRequestModel(HospitalsRequestModel hospitalsRequestModel) {
        this.hospitalsRequestModel = hospitalsRequestModel;
    }

    public void getHospitals() {
        Log.d("TAG", "getHospitals: "+hospitalsRequestModel.getLatitude()+" : "+hospitalsRequestModel.getLongitude());
        data =  hospitalRepository.getHospitals(this.applicationId,this.contentType,this.hospitalsRequestModel);

    }

    public LiveData<HospitalsResponseModel> getHospitalsData() {
        return data;
    }
}
