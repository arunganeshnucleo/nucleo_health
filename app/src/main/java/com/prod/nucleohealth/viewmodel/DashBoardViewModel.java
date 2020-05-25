package com.prod.nucleohealth.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.prod.nucleohealth.data.model.Header;
import com.prod.nucleohealth.data.model.request.UserDetailsRequestModel;
import com.prod.nucleohealth.data.model.response.UserDetailsResponseModel;
import com.prod.nucleohealth.data.repository.UserRepository;

public class DashBoardViewModel extends AndroidViewModel {
    private UserRepository repository;
    private String clientId;
    private Header header;
    private LiveData<UserDetailsResponseModel> data;
    public DashBoardViewModel(@NonNull Application application) {
        super(application);
        repository = new UserRepository();
    }


    public void setHeader(String accept,String acceptToken){
        header = new Header();
        header.setAccept(accept);
        header.setAccessToken(acceptToken);
    }

    public void setClientId(String clientId){
        this.clientId = clientId;
    }
    public void getUserDetails() {
        UserDetailsRequestModel userDetailsRequestModel = new UserDetailsRequestModel();
        userDetailsRequestModel.setClient_id(this.clientId);
        data =  repository.getUserDetailsByClientId(this.header.getAccept(),this.header.getAccessToken(),userDetailsRequestModel);
    }

    public LiveData<UserDetailsResponseModel> getUserDetailsData() {
        return data;
    }
}
