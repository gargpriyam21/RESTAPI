package com.example.neera.restapi.activites

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

import com.example.neera.restapi.R
import com.example.neera.restapi.adapters.TodosAdapter
import com.example.neera.restapi.api.ApiService
import com.example.neera.restapi.models.Todo

import kotlinx.android.synthetic.main.activity_todos.*

import java.util.ArrayList

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TodosActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todos)

        rvTodos.layoutManager = LinearLayoutManager(this)

        val id = intent.getIntExtra("IdforTodo", 0)

        val todosAdapter = TodosAdapter(this)
        rvTodos.adapter = todosAdapter

        if (id != 0) {
            ApiService.getAPI().GetTodoOfUser(id).enqueue(object : Callback<ArrayList<Todo>> {
                override fun onResponse(call: Call<ArrayList<Todo>>, response: Response<ArrayList<Todo>>) {
                    todosAdapter.updateTodos(response.body()!!)
                }

                override fun onFailure(call: Call<ArrayList<Todo>>, t: Throwable) {

                }
            })
        } else {
            ApiService.getAPI().todos.enqueue(object : Callback<ArrayList<Todo>> {
                override fun onResponse(call: Call<ArrayList<Todo>>, response: Response<ArrayList<Todo>>) {
                    todosAdapter.updateTodos(response.body()!!)
                }

                override fun onFailure(call: Call<ArrayList<Todo>>, t: Throwable) {

                }
            })
        }
    }
}
