package com.example.neera.restapi.activites;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.example.neera.restapi.R;
import com.example.neera.restapi.adapters.PostsAdapter;
import com.example.neera.restapi.api.ApiService;
import com.example.neera.restapi.models.Post;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostsActivity extends AppCompatActivity {

    RecyclerView rvPosts;
    LinearLayout llPosts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);

        rvPosts = (RecyclerView) findViewById(R.id.rvPosts);
        rvPosts.setLayoutManager(new LinearLayoutManager(this));

        int id = getIntent().getIntExtra("IdforPost", 0);

        final PostsAdapter postsAdapter = new PostsAdapter(this);
        rvPosts.setAdapter(postsAdapter);

        if (id != 0) {
            ApiService.getAPI().GetPostOfUser(id).enqueue(new Callback<ArrayList<Post>>() {
                @Override
                public void onResponse(Call<ArrayList<Post>> call, Response<ArrayList<Post>> response) {
                    postsAdapter.updatePosts(response.body());
                }

                @Override
                public void onFailure(Call<ArrayList<Post>> call, Throwable t) {

                }
            });
        } else {
            ApiService.getAPI().getPosts().enqueue(new Callback<ArrayList<Post>>() {
                @Override
                public void onResponse(Call<ArrayList<Post>> call, Response<ArrayList<Post>> response) {
                    postsAdapter.updatePosts(response.body());
                }

                @Override
                public void onFailure(Call<ArrayList<Post>> call, Throwable t) {

                }
            });

        }

    }
}
