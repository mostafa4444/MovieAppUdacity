package com.mostafa.root.retrofittesting.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieResponseUpcoming {

    @SerializedName("results")
    @Expose
    private List<MovieObjUpcoming> results;


    public List<MovieObjUpcoming> getResults() {
        return results;
    }

    public void setResults(List<MovieObjUpcoming> results) {
        this.results = results;
    }
}
