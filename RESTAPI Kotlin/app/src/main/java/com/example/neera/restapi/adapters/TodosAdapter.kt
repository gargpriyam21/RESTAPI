package com.example.neera.restapi.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox

import com.example.neera.restapi.R
import com.example.neera.restapi.models.Todo

import java.util.ArrayList

/**
 * Created by Neera on 26/09/17.
 */

class TodosAdapter(internal var context: Context) : RecyclerView.Adapter<TodosAdapter.TodoViewHolder>() {

    internal var todos = ArrayList<Todo>()

    fun updateTodos(todos: ArrayList<Todo>) {
        this.todos = todos
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val li = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        return TodosAdapter.TodoViewHolder(li.inflate(R.layout.list_item_todo, parent, false))
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bindView(todos[position])
    }

    override fun getItemCount(): Int {
        return todos.size
    }

    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cbTodoTitle: CheckBox

        init {
            cbTodoTitle = itemView.findViewById(R.id.cbTodoTitle)
        }

        fun bindView(todo: Todo) {
            cbTodoTitle.text = todo.title
            cbTodoTitle.isChecked = todo.isCompleted
        }
    }
}
