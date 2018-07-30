package com.mostafa.root.retrofittesting.WebServices;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Path;

public interface GithubServices {
    @GET("users/{username}/repos")
    Call<ResponseBody>getResponseOfuser(@Path("username") String username);
}
