package com.example.neera.restapi

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageButton

import com.example.neera.restapi.activites.AlbumsActivity
import com.example.neera.restapi.activites.PostsActivity
import com.example.neera.restapi.activites.TodosActivity
import com.example.neera.restapi.activites.UsersActivity

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnUsers.setOnClickListener {
            startActivity(Intent(this@MainActivity, UsersActivity::class.java))
        }

        btnPosts.setOnClickListener {
            startActivity(Intent(this@MainActivity, PostsActivity::class.java))
        }

        btnAlbums.setOnClickListener {
            startActivity(Intent(this@MainActivity, AlbumsActivity::class.java))
        }

        btnTodos.setOnClickListener {
            startActivity(Intent(this@MainActivity, TodosActivity::class.java))
        }

    }


}
