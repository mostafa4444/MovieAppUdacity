package com.mostafa.root.retrofittesting.WebServices;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface NewsServices {
    @GET("top-headlines")
    Call<ResponseBody> getNews(@Query("apiKey") String apiKey , @Query("country") String country , @Query("category") String category);


    @GET("top-headlines")
    Call<ResponseBody> getNewsByMap(@QueryMap Map<String , String> myParameters);
}
