package com.prod.nucleohealth.data.api;

import com.prod.nucleohealth.data.model.request.FavoriteHospitalRequestModel;
import com.prod.nucleohealth.data.model.request.UserDetailsRequestModel;
import com.prod.nucleohealth.data.model.response.FavoriteHosptitalResponseModel;
import com.prod.nucleohealth.data.model.response.UserDetailsResponseModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface UserHospitalWebService {
    @POST("getallFavouritesbyclientId")
    Call<FavoriteHosptitalResponseModel> getFavoriteHospitals(@Header("accept") String accept_header, @Header("Authorization") String auth_token, @Body FavoriteHospitalRequestModel favoriteHospitalRequestModel);
}
