package com.example.neera.restapi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.example.neera.restapi.activites.AlbumsActivity;
import com.example.neera.restapi.activites.PostsActivity;
import com.example.neera.restapi.activites.TodosActivity;
import com.example.neera.restapi.activites.UsersActivity;

public class MainActivity extends AppCompatActivity {

    ImageButton btnUsers, btnPosts, btnAlbums, btnTodos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnUsers = (ImageButton) findViewById(R.id.btnUsers);
        btnPosts = (ImageButton) findViewById(R.id.btnPosts);
        btnAlbums = (ImageButton) findViewById(R.id.btnAlbums);
        btnTodos = (ImageButton) findViewById(R.id.btnTodos);

        View.OnClickListener onButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = null;
                switch (view.getId()) {
                    case R.id.btnUsers:
                        i = new Intent(MainActivity.this, UsersActivity.class);
                        break;
                    case R.id.btnPosts:
                        i = new Intent(MainActivity.this, PostsActivity.class);
                        break;
                    case R.id.btnAlbums:
                        i = new Intent(MainActivity.this, AlbumsActivity.class);
                        break;
                    case R.id.btnTodos:
                        i = new Intent(MainActivity.this, TodosActivity.class);
                        break;
                }
                startActivity(i);
            }
        };

        btnUsers.setOnClickListener(onButtonClickListener);
        btnPosts.setOnClickListener(onButtonClickListener);
        btnAlbums.setOnClickListener(onButtonClickListener);
        btnTodos.setOnClickListener(onButtonClickListener);
    }


}
