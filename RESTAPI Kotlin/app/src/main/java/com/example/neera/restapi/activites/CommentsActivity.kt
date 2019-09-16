package com.example.neera.restapi.activites

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

import com.example.neera.restapi.R
import com.example.neera.restapi.adapters.CommentsAdapter
import com.example.neera.restapi.api.ApiService
import com.example.neera.restapi.models.Comment

import kotlinx.android.synthetic.main.activity_comments.*

import java.util.ArrayList

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comments)

        rvComments.layoutManager = LinearLayoutManager(this)

        val id = intent.getIntExtra("postId", 0)

        val commentsAdapter = CommentsAdapter(this)
        rvComments.adapter = commentsAdapter

        ApiService.getAPI().getComments(id).enqueue(object : Callback<ArrayList<Comment>> {
            override fun onResponse(call: Call<ArrayList<Comment>>, response: Response<ArrayList<Comment>>) {
                commentsAdapter.updatecomments(response.body()!!)
            }

            override fun onFailure(call: Call<ArrayList<Comment>>, t: Throwable) {

            }
        })
    }
}
