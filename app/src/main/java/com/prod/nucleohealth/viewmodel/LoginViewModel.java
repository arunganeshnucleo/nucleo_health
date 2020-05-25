package com.prod.nucleohealth.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.prod.nucleohealth.data.model.request.LoginRequestModel;
import com.prod.nucleohealth.data.model.response.LoginResponseModel;
import com.prod.nucleohealth.data.repository.UserRepository;

public class LoginViewModel extends AndroidViewModel {
    private LiveData<LoginResponseModel> data;
    private UserRepository repository;


    public LoginViewModel(Application application) {
        super(application);
        repository = new UserRepository();
    }

    public void loginUser(LoginRequestModel loginRequestModel) {
        data =  repository.loginUser(loginRequestModel);
    }

    public LiveData<LoginResponseModel> getUserData() {
        return data;
    }
}
