package com.example.test.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AlbumResponse
{
    @SerializedName("records")
    private List<Album> results;

    public List<Album> getResults()
    {
        return results;
    }

    public void setResults(List<Album> results)
    {
        this.results = results;
    }
}
