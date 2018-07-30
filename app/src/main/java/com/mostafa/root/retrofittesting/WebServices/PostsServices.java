package com.mostafa.root.retrofittesting.WebServices;

import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface PostsServices {
    @GET("posts")
    Call<ResponseBody> getPosts();

//    @POST("posts")
//    Call<ResponseBody> newPost(String title , String content);
//
//    @PUT("posts")
//    Call<ResponseBody> updatePost(int id , String title , String content);
//
//    @DELETE("posts")
//    Call<ResponseBody> deletePost(int id);
}
