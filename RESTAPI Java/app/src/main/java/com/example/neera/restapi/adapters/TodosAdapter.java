package com.example.neera.restapi.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.example.neera.restapi.R;
import com.example.neera.restapi.models.Todo;

import java.util.ArrayList;

/**
 * Created by Neera on 26/09/17.
 */

public class TodosAdapter extends RecyclerView.Adapter<TodosAdapter.TodoViewHolder> {

    ArrayList<Todo> todos = new ArrayList<>();
    Context context;

    public TodosAdapter(Context context) {
        this.context = context;
    }

    public void updateTodos(ArrayList<Todo> todos) {
        this.todos = todos;
        notifyDataSetChanged();
    }

    @Override
    public TodoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return new TodosAdapter.TodoViewHolder(li.inflate(R.layout.list_item_todo, parent, false));
    }

    @Override
    public void onBindViewHolder(TodoViewHolder holder, int position) {
        holder.bindView(todos.get(position));
    }

    @Override
    public int getItemCount() {
        return todos.size();
    }

    class TodoViewHolder extends RecyclerView.ViewHolder {
        CheckBox cbTodoTitle;

        public TodoViewHolder(View itemView) {
            super(itemView);
            cbTodoTitle = itemView.findViewById(R.id.cbTodoTitle);
        }

        void bindView(Todo todo) {
            cbTodoTitle.setText(todo.getTitle());
            cbTodoTitle.setChecked(todo.isCompleted());
        }
    }
}
