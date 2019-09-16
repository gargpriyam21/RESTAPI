package com.example.neera.restapi.activites;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.neera.restapi.R;
import com.example.neera.restapi.adapters.TodosAdapter;
import com.example.neera.restapi.api.ApiService;
import com.example.neera.restapi.models.Todo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TodosActivity extends AppCompatActivity {

    RecyclerView rvTodos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todos);

        rvTodos = (RecyclerView) findViewById(R.id.rvTodos);
        rvTodos.setLayoutManager(new LinearLayoutManager(this));

        int id = getIntent().getIntExtra("IdforTodo", 0);

        final TodosAdapter todosAdapter = new TodosAdapter(this);
        rvTodos.setAdapter(todosAdapter);

        if (id != 0) {
            ApiService.getAPI().GetTodoOfUser(id).enqueue(new Callback<ArrayList<Todo>>() {
                @Override
                public void onResponse(Call<ArrayList<Todo>> call, Response<ArrayList<Todo>> response) {
                    todosAdapter.updateTodos(response.body());
                }

                @Override
                public void onFailure(Call<ArrayList<Todo>> call, Throwable t) {

                }
            });
        } else {
            ApiService.getAPI().getTodos().enqueue(new Callback<ArrayList<Todo>>() {
                @Override
                public void onResponse(Call<ArrayList<Todo>> call, Response<ArrayList<Todo>> response) {
                    todosAdapter.updateTodos(response.body());
                }

                @Override
                public void onFailure(Call<ArrayList<Todo>> call, Throwable t) {

                }
            });
        }
    }
}
