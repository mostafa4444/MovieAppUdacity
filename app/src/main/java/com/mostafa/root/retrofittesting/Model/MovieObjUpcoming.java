package com.mostafa.root.retrofittesting.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import io.realm.annotations.PrimaryKey;

public class MovieObjUpcoming {

    @PrimaryKey
    @SerializedName("id")
    @Expose
    private int movie_id;

    @SerializedName("genre_ids")
    @Expose
    private List<Integer> movie_genreIds = new ArrayList<Integer>();

    @SerializedName("video")
    @Expose
    private boolean movie_is_video;

    @SerializedName("adult")
    @Expose
    private boolean movie_is_adult;

    @SerializedName("original_title")
    @Expose
    private String movie_original_title;

    @SerializedName("language")
    @Expose
    private String movie_original_language;

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
    private String movie_popularity;

    @SerializedName("vote_count")
    @Expose
    private Double movie_vote;


    public MovieObjUpcoming() {
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public List<Integer> getMovie_genreIds() {
        return movie_genreIds;
    }

    public void setMovie_genreIds(List<Integer> movie_genreIds) {
        this.movie_genreIds = movie_genreIds;
    }

    public boolean isMovie_is_video() {
        return movie_is_video;
    }

    public void setMovie_is_video(boolean movie_is_video) {
        this.movie_is_video = movie_is_video;
    }

    public boolean isMovie_is_adult() {
        return movie_is_adult;
    }

    public void setMovie_is_adult(boolean movie_is_adult) {
        this.movie_is_adult = movie_is_adult;
    }

    public String getMovie_original_title() {
        return movie_original_title;
    }

    public void setMovie_original_title(String movie_original_title) {
        this.movie_original_title = movie_original_title;
    }

    public String getMovie_original_language() {
        return movie_original_language;
    }

    public void setMovie_original_language(String movie_original_language) {
        this.movie_original_language = movie_original_language;
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

    public String getMovie_popularity() {
        return movie_popularity;
    }

    public void setMovie_popularity(String movie_popularity) {
        this.movie_popularity = movie_popularity;
    }

    public Double getMovie_vote() {
        return movie_vote;
    }

    public void setMovie_vote(Double movie_vote) {
        this.movie_vote = movie_vote;
    }
}
