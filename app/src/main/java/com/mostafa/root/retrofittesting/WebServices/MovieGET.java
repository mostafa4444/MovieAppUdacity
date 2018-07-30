package com.mostafa.root.retrofittesting.WebServices;

import com.mostafa.root.retrofittesting.Model.MovieResponse;
import com.mostafa.root.retrofittesting.Model.MovieResponseUpcoming;
import com.mostafa.root.retrofittesting.Model.ReviewResponse;
import com.mostafa.root.retrofittesting.Model.TrailerResponse;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieGET{
    @GET("popular")
    Call<MovieResponse> getPopularMovies(@Query("api_key") String key , @Query("page") String page);

    @GET("top_rated")
    Call<MovieResponse> getTopRatedMovies(@Query("api_key") String key , @Query("page") String page) ;

    @GET("upcoming")
    Call<MovieResponseUpcoming> getUpcomingMovies(@Query("api_key") String key , @Query("page") String page);

    @GET("3/movie/{id}/reviews")
    Call<ReviewResponse> findReviewsById(@Path("id") long movieId, @Query("api_key") String apiKey);

    @GET("3/movie/{id}/videos")
    Call<TrailerResponse> getMovieTrailers(@Path("id") String movieId, @Query("api_key") String apiKey);

}
