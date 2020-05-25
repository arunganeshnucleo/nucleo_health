package com.prod.nucleohealth.data.api;

import com.prod.nucleohealth.data.model.request.FamilyDetailsRequestModel;
import com.prod.nucleohealth.data.model.request.LoginRequestModel;
import com.prod.nucleohealth.data.model.request.UserDetailsRequestModel;
import com.prod.nucleohealth.data.model.response.FamilyDetailsResponseModel;
import com.prod.nucleohealth.data.model.response.LoginResponseModel;
import com.prod.nucleohealth.data.model.response.UserDetailsResponseModel;
import com.prod.nucleohealth.utils.Constants;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface UserAccountWebService {

    @POST("login")
    Call<LoginResponseModel> loginUser(@Header("accept") String accept_header, @Header("application_id") String application_id, @Header("Content-Type") String contentType, @Body LoginRequestModel loginRequestModel);

    @POST("getClientById")
    Call<UserDetailsResponseModel> getUserDetailsByClientId(@Header("accept") String accept_header, @Header("Authorization") String auth_token, @Body UserDetailsRequestModel userDetailsRequestModel);

    @POST("getClientFamilyDetails")
    Call<FamilyDetailsResponseModel> getUserFamilyList(@Header("accept") String accept_header, @Header("Authorization") String auth_token, @Body FamilyDetailsRequestModel familyDetailsRequestModel);

    //Social media login
    //@POST("user/social_login")
    //Call<LoginResponseModel> socialLoginUser(@Header("Content-Type") String content_type, @Body LoginRequestModel loginRequestModel);
}
