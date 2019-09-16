package com.example.neera.restapi.activites

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

import com.example.neera.restapi.R
import com.example.neera.restapi.adapters.UsersAdapter
import com.example.neera.restapi.api.ApiService
import com.example.neera.restapi.models.User

import kotlinx.android.synthetic.main.activity_users.*


import java.util.ArrayList

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UsersActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)

        rvUsers.layoutManager = LinearLayoutManager(this)

        val usersAdapter = UsersAdapter(this)
        rvUsers.adapter = usersAdapter

        ApiService.getAPI().users.enqueue(object : Callback<ArrayList<User>> {
            override fun onResponse(call: Call<ArrayList<User>>, response: Response<ArrayList<User>>) {
                usersAdapter.updateUsers(response.body()!!)
            }

            override fun onFailure(call: Call<ArrayList<User>>, t: Throwable) {

            }
        })

    }
}
