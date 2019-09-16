package com.example.neera.restapi.activites

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

import com.example.neera.restapi.R
import com.example.neera.restapi.adapters.PhotosAdapter
import com.example.neera.restapi.api.ApiService
import com.example.neera.restapi.models.Photo

import kotlinx.android.synthetic.main.activity_photos.*

import java.util.ArrayList

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PhotosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photos)

        rvPhotos.layoutManager = LinearLayoutManager(this)

        val id = intent.getIntExtra("albumId", 0)

        val photosAdapter = PhotosAdapter(this)
        rvPhotos.adapter = photosAdapter

        ApiService.getAPI().getphotos(id).enqueue(object : Callback<ArrayList<Photo>> {
            override fun onResponse(call: Call<ArrayList<Photo>>, response: Response<ArrayList<Photo>>) {
                photosAdapter.updatephotos(response.body()!!)
            }

            override fun onFailure(call: Call<ArrayList<Photo>>, t: Throwable) {

            }
        })
    }
}
