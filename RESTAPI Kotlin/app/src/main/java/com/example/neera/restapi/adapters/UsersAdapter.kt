package com.example.neera.restapi.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

import com.example.neera.restapi.R
import com.example.neera.restapi.activites.PostsActivity
import com.example.neera.restapi.activites.TodosActivity
import com.example.neera.restapi.models.User

import java.util.ArrayList

/**
 * Created by Neera on 26/09/17.
 */

class UsersAdapter(internal var context: Context) : RecyclerView.Adapter<UsersAdapter.UserViewHolder>() {

    internal var users = ArrayList<User>()

    fun updateUsers(users: ArrayList<User>) {
        this.users = users
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val li = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        return UserViewHolder(li.inflate(R.layout.list_item_user, parent, false))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bindView(users[position])
    }

    override fun getItemCount(): Int {
        return users.size
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvUserName: TextView
        var tvUserUsername: TextView
        var tvUserEmail: TextView
        var tvUserPhone: TextView
        var btnUserPost: Button
        var btnUserTodos: Button

        init {
            tvUserName = itemView.findViewById(R.id.tvUserName)
            tvUserUsername = itemView.findViewById(R.id.tvUserUsername)
            tvUserEmail = itemView.findViewById(R.id.tvUserEmail)
            tvUserPhone = itemView.findViewById(R.id.tvUserPhone)
            btnUserPost = itemView.findViewById(R.id.btnUserPost)
            btnUserTodos = itemView.findViewById(R.id.btnUserTodos)
        }

        fun bindView(user: User) {
            tvUserName.text = user.name
            tvUserUsername.text = user.username
            tvUserEmail.text = user.email
            tvUserPhone.text = user.phone

            btnUserPost.setOnClickListener {
                val i = Intent(context, PostsActivity::class.java)
                i.putExtra("IdforPost", user.id)
                context.startActivity(i)
            }

            btnUserTodos.setOnClickListener {
                val i = Intent(context, TodosActivity::class.java)
                i.putExtra("IdforTodo", user.id)
                context.startActivity(i)
            }
        }
    }
}
