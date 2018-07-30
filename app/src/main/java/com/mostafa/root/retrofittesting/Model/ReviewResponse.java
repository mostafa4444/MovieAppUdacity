package com.mostafa.root.retrofittesting.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ReviewResponse {

    @SerializedName("results")
    private List<ReviewObj> reviews = new ArrayList<>();

    public List<ReviewObj> getReviews() {
        return reviews;
    }
}
