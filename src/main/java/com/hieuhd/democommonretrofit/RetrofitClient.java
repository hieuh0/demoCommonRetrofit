package com.hieuhd.democommonretrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static RetrofitService retrofit = null;


    public static RetrofitService getClient() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://192.168.1.30")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build().create(RetrofitService.class);
        }
        return retrofit;
    }
}
