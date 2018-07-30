package com.mostafa.root.retrofittesting.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TrailerObj {

    @SerializedName("id")
    @Expose
    private String id;


    @SerializedName("key")
    @Expose
    private String key;


    @SerializedName("name")
    @Expose
    private String name;


    @SerializedName("site")
    @Expose
    private String site;


    @SerializedName("size")
    @Expose
    private String size;


    @SerializedName("type")
    @Expose
    private String type;

    public TrailerObj() {
    }

    public String getTrailerUrl() {
        return "http://www.youtube.com/watch?v=" + key;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
