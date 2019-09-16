package com.example.neera.restapi.activites;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.neera.restapi.R;
import com.example.neera.restapi.adapters.PhotosAdapter;
import com.example.neera.restapi.api.ApiService;
import com.example.neera.restapi.models.Photo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotosActivity extends AppCompatActivity {
    RecyclerView rvPhotos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);

        rvPhotos = (RecyclerView) findViewById(R.id.rvPhotos);
        rvPhotos.setLayoutManager(new LinearLayoutManager(this));

        int id = getIntent().getIntExtra("albumId", 0);

        final PhotosAdapter photosAdapter = new PhotosAdapter(this);
        rvPhotos.setAdapter(photosAdapter);

        ApiService.getAPI().getphotos(id).enqueue(new Callback<ArrayList<Photo>>() {
            @Override
            public void onResponse(Call<ArrayList<Photo>> call, Response<ArrayList<Photo>> response) {
                photosAdapter.updatephotos(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Photo>> call, Throwable t) {

            }
        });
    }
}
