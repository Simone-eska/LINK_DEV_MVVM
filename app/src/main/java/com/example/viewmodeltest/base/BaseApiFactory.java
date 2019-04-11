package com.example.viewmodeltest.base;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public abstract class BaseApiFactory <T>{

    private static final String  BASE_URL="https://newsapi.org/v1/";
    static Retrofit retrofit;

    public static Retrofit getInstance(){
        if(retrofit==null)
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();

        return retrofit;
    }

    public abstract T initiate();
}
