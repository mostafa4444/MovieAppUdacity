package com.mostafa.root.retrofittesting.Model;

public class MovieDatabaseModel {
    private int id;
    private String movie_id;
    private String movie_name;
    private String movie_img;
    private String movie_poster;
    private String movie_rate;
    private String movie_date;

    public MovieDatabaseModel() {
    }

    public MovieDatabaseModel(String movie_id, String movie_name, String movie_img, String movie_poster, String movie_rate, String movie_date) {
        this.movie_id = movie_id;
        this.movie_name = movie_name;
        this.movie_img = movie_img;
        this.movie_poster = movie_poster;
        this.movie_rate = movie_rate;
        this.movie_date = movie_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(String movie_id) {
        this.movie_id = movie_id;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public String getMovie_img() {
        return movie_img;
    }

    public void setMovie_img(String movie_img) {
        this.movie_img = movie_img;
    }

    public String getMovie_poster() {
        return movie_poster;
    }

    public void setMovie_poster(String movie_poster) {
        this.movie_poster = movie_poster;
    }

    public String getMovie_rate() {
        return movie_rate;
    }

    public void setMovie_rate(String movie_rate) {
        this.movie_rate = movie_rate;
    }

    public String getMovie_date() {
        return movie_date;
    }

    public void setMovie_date(String movie_date) {
        this.movie_date = movie_date;
    }
}
