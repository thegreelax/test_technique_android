package com.example.test.Rest;

import com.example.test.Model.AlbumResponse;

import retrofit2.Call;
import retrofit2.http.GET;


public interface AlbumService
{
    @GET("album/read.php")
    Call<AlbumResponse> getMusicAlbums();
}
