package com.hieuhd.democommonretrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Url;

public interface RetrofitService {
    @GET
    @Headers("Content-Type: application/json")
    Call<User> testConnection(@Url String customUrl);
}
