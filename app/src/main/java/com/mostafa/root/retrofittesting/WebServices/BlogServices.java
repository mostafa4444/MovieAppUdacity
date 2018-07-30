package com.mostafa.root.retrofittesting.WebServices;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface BlogServices {
    @POST("posts")
    @FormUrlEncoded
    Call<ResponseBody> createNewPost(@Field("title") String title , @Field("body") String body , @Field("userId") int userId);


    @Headers("Content-Type: application/json")
    @POST("login")
    Call<ResponseBody> test(@Body Map<String , String> params);
}
