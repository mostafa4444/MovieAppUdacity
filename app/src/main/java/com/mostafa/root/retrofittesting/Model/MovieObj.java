package com.mostafa.root.retrofittesting.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import io.realm.annotations.PrimaryKey;


public class MovieObj  {

    @PrimaryKey
    @SerializedName("id")
    @Expose
    private long movie_id;

    @SerializedName("genre_ids")
    @Expose
    private List<Integer> genreIds = new ArrayList<Integer>();

    @SerializedName("backdrop_path")
    @Expose
    private String movie_image;

    @SerializedName("poster_path")
    @Expose
    private String movie_poster;

    @SerializedName("overview")
    @Expose
    private String movie_description;

    @SerializedName("release_date")
    @Expose
    private String movie_date;

    @SerializedName("title")
    @Expose
    private String movie_name;

    @SerializedName("vote_average")
    @Expose
    private Double movie_rate;

    @SerializedName("popularity")
    @Expose
    private String popularity;


    public MovieObj() {
    }



    public String getMovie_image() {
        return movie_image;
    }

    public void setMovie_image(String movie_image) {
        this.movie_image = movie_image;
    }

    public String getMovie_poster() {
        return movie_poster;
    }

    public void setMovie_poster(String movie_poster) {
        this.movie_poster = movie_poster;
    }

    public String getMovie_description() {
        return movie_description;
    }

    public void setMovie_description(String movie_description) {
        this.movie_description = movie_description;
    }

    public String getMovie_date() {
        return movie_date;
    }

    public void setMovie_date(String movie_date) {
        this.movie_date = movie_date;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public Double getMovie_rate() {
        return movie_rate;
    }

    public void setMovie_rate(Double movie_rate) {
        this.movie_rate = movie_rate;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }

    public void setMovie_id(long movie_id) {
        this.movie_id = movie_id;
    }

    public long getMovie_id() {
        return movie_id;
    }
    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

}