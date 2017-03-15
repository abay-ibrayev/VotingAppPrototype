package com.shareholder.abay.finapps.finappsproject.rest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by abay on 10/24/16.
 */
public interface RestInterface {
    @POST("user/login")
    Call<SimpleResponse> checkUser(@Header("Authorization") String header, @Body User user);
}
