package com.shareholder.abay.finapps.finappsproject.rest;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by abay on 10/24/16.
 */
public class RestClient {
    public static final String BASE_URL = "http://192.168.1.106:8080";
    private static Retrofit retrofit = null;

    private RestInterface restInterface;

    public static Retrofit getClient(){
        if(retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public RestInterface request() {
        restInterface = retrofit.create(RestInterface.class);
        return restInterface;
    }

    public interface RestInterface {
        @POST("user/login")
        Call<SimpleResponse> checkUser(@Body User user);
    }
}
