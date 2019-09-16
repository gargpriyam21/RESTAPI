package com.example.neera.restapi.activites

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

import com.example.neera.restapi.R
import com.example.neera.restapi.adapters.AlbumsAdapter
import com.example.neera.restapi.api.ApiService
import com.example.neera.restapi.models.Album

import kotlinx.android.synthetic.main.activity_albums.*

import java.util.ArrayList

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AlbumsActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_albums)

        rvAlbums.layoutManager = LinearLayoutManager(this)

        val albumsAdapter = AlbumsAdapter(this)
        rvAlbums.adapter = albumsAdapter

        ApiService.getAPI().albums.enqueue(object : Callback<ArrayList<Album>> {
            override fun onResponse(call: Call<ArrayList<Album>>, response: Response<ArrayList<Album>>) {
                albumsAdapter.updateAlbums(response.body()!!)
            }

            override fun onFailure(call: Call<ArrayList<Album>>, t: Throwable) {

            }
        })
    }
}
