package com.mostafa.root.retrofittesting.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class TrailerResponse {
    @SerializedName("results")
    @Expose
    private List<TrailerObj> trailers = new ArrayList<>();

    @SerializedName("id")
    @Expose
    private int id;


    public TrailerResponse() {
    }

    public List<TrailerObj> getTrailers() {
        return trailers;
    }

    public void setTrailers(List<TrailerObj> trailers) {
        this.trailers = trailers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
