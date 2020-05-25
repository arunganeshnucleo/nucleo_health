package com.prod.nucleohealth.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.prod.nucleohealth.data.model.response.SpecialityResponseModel;
import com.prod.nucleohealth.data.repository.HospitalRepository;

public class SpecialityFilterViewModel extends AndroidViewModel {
    private LiveData<SpecialityResponseModel> data;
    private HospitalRepository hospitalRepository;
    private String applicationId;
    private String accept;

    public SpecialityFilterViewModel(@NonNull Application application) {
        super(application);
        hospitalRepository = new HospitalRepository();
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        this.accept = accept;
    }

    public void getSpecialities() {
        data =  hospitalRepository.getSpecialities(this.applicationId,this.accept);
    }

    public LiveData<SpecialityResponseModel> getSpecialitesData() {
        return data;
    }
}
