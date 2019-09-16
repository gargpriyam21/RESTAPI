package com.example.neera.restapi.activites;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.neera.restapi.R;
import com.example.neera.restapi.adapters.CommentsAdapter;
import com.example.neera.restapi.api.ApiService;
import com.example.neera.restapi.models.Comment;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommentsActivity extends AppCompatActivity {

    RecyclerView rvComments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);

        rvComments = (RecyclerView) findViewById(R.id.rvComments);
        rvComments.setLayoutManager(new LinearLayoutManager(this));

        int id = getIntent().getIntExtra("postId", 0);

        final CommentsAdapter commentsAdapter = new CommentsAdapter(this);
        rvComments.setAdapter(commentsAdapter);

        ApiService.getAPI().getComments(id).enqueue(new Callback<ArrayList<Comment>>() {
            @Override
            public void onResponse(Call<ArrayList<Comment>> call, Response<ArrayList<Comment>> response) {
                commentsAdapter.updatecomments(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Comment>> call, Throwable t) {

            }
        });
    }
}
