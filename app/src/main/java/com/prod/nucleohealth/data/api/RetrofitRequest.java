package com.prod.nucleohealth.data.api;

import com.prod.nucleohealth.utils.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitRequest {

    public static Retrofit retrofit;
    public static Retrofit getInstance() {
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_PHP_URL_DEV)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }

}
