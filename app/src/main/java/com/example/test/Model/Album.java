package com.example.test.Model;

import com.google.gson.annotations.SerializedName;

public class Album
{
    @SerializedName("id")
    private int id;
    @SerializedName("title")
    private String title;
    @SerializedName("cover")
    private String cover;
    @SerializedName("musician")
    private String musician;

    public Album(String title, String cover, String musician)
    {
        this.title = title;
        this.cover = cover;
        this.musician = musician;
    }

    public String getTitle() {
        return title;
    }

    public String getCover() {
        return cover;
    }

    public String getMusician() {
        return musician;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public void setMusician(String musician) {
        this.musician = musician;
    }


}
