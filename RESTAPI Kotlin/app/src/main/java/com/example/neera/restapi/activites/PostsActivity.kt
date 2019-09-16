package com.example.neera.restapi.activites

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout

import com.example.neera.restapi.R
import com.example.neera.restapi.adapters.PostsAdapter
import com.example.neera.restapi.api.ApiService
import com.example.neera.restapi.models.Post

import kotlinx.android.synthetic.main.activity_posts.*


import java.util.ArrayList

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostsActivity : AppCompatActivity() {

    internal var llPosts: LinearLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_posts)

        rvPosts.layoutManager = LinearLayoutManager(this)

        val id = intent.getIntExtra("IdforPost", 0)

        val postsAdapter = PostsAdapter(this)
        rvPosts.adapter = postsAdapter

        if (id != 0) {
            ApiService.getAPI().GetPostOfUser(id).enqueue(object : Callback<ArrayList<Post>> {
                override fun onResponse(call: Call<ArrayList<Post>>, response: Response<ArrayList<Post>>) {
                    postsAdapter.updatePosts(response.body()!!)
                }

                override fun onFailure(call: Call<ArrayList<Post>>, t: Throwable) {

                }
            })
        } else {
            ApiService.getAPI().posts.enqueue(object : Callback<ArrayList<Post>> {
                override fun onResponse(call: Call<ArrayList<Post>>, response: Response<ArrayList<Post>>) {
                    postsAdapter.updatePosts(response.body()!!)
                }

                override fun onFailure(call: Call<ArrayList<Post>>, t: Throwable) {

                }
            })

        }

    }
}
