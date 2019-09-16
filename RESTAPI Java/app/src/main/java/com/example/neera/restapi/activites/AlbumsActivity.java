package com.example.neera.restapi.activites;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.neera.restapi.R;
import com.example.neera.restapi.adapters.AlbumsAdapter;
import com.example.neera.restapi.api.ApiService;
import com.example.neera.restapi.models.Album;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumsActivity extends AppCompatActivity {

    RecyclerView rvAlbums;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);

        rvAlbums = (RecyclerView) findViewById(R.id.rvAlbums);
        rvAlbums.setLayoutManager(new LinearLayoutManager(this));

        final AlbumsAdapter albumsAdapter = new AlbumsAdapter(this);
        rvAlbums.setAdapter(albumsAdapter);

        ApiService.getAPI().getAlbums().enqueue(new Callback<ArrayList<Album>>() {
            @Override
            public void onResponse(Call<ArrayList<Album>> call, Response<ArrayList<Album>> response) {
                albumsAdapter.updateAlbums(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Album>> call, Throwable t) {

            }
        });
    }
}
