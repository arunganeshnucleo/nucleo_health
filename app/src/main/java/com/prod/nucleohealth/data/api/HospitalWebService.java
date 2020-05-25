package com.prod.nucleohealth.data.api;

import com.prod.nucleohealth.data.model.request.HospitalsRequestModel;
import com.prod.nucleohealth.data.model.response.HospitalsResponseModel;
import com.prod.nucleohealth.data.model.response.LoginResponseModel;
import com.prod.nucleohealth.data.model.response.SpecialityResponseModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface HospitalWebService {
    @GET("getAllSpecialities")
    Call<SpecialityResponseModel> getSpecialities(@Header("application_id") String application_id,@Header("accept") String accept);

    @POST("searchResult")
    Call<HospitalsResponseModel> getHospitals(@Header("application_id") String application_id, @Header("Content-Type") String contentType,@Body HospitalsRequestModel hospitalsRequestModel);
}
