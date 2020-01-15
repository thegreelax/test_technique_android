package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.test.Adapter.AlbumAdapter;
import com.example.test.Model.Album;
import com.example.test.Model.AlbumResponse;
import com.example.test.Rest.AlbumService;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Display extends AppCompatActivity
{
    private static final String Tag = Display.class.getSimpleName();
    public static final String apiURL = "http://192.168.0.140/music-albums-test/";
    private static Retrofit retrofit = null;
    private RecyclerView recyclerView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.connectAndGetApiData();
    }

    public void connectAndGetApiData()
    {
        if (retrofit == null)
        {
            retrofit = new Retrofit.Builder().baseUrl(apiURL).addConverterFactory(GsonConverterFactory.create()).build();
        }

        AlbumService albumApiService = retrofit.create(AlbumService.class);
        Call<AlbumResponse> call = albumApiService.getMusicAlbums();

        call.enqueue(new Callback<AlbumResponse>()
        {

            @Override
            public void onResponse(Call<AlbumResponse> call, Response<AlbumResponse> response)
            {
                Log.d(Tag,"coucou !");
                List<Album> albums = response.body().getResults();
                Log.d(Tag, response.body().getResults().toString());

                recyclerView.setAdapter(new AlbumAdapter(albums, R.layout.list_item_album, getApplicationContext()));
                Log.d(Tag, "Number of movies received: " + albums.size());
            }

            @Override
            public void onFailure(Call<AlbumResponse> call, Throwable t)
            {
                Log.e(Tag, t.toString());
            }
        });
    }
}
