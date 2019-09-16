package com.example.neera.restapi.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.neera.restapi.R;
import com.example.neera.restapi.activites.PostsActivity;
import com.example.neera.restapi.activites.TodosActivity;
import com.example.neera.restapi.models.User;

import java.util.ArrayList;

/**
 * Created by Neera on 26/09/17.
 */

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UserViewHolder> {

    ArrayList<User> users = new ArrayList<>();
    Context context;

    public UsersAdapter(Context context) {
        this.context = context;
    }

    public void updateUsers(ArrayList<User> users) {
        this.users = users;
        notifyDataSetChanged();
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return new UserViewHolder(li.inflate(R.layout.list_item_user, parent, false));
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        holder.bindView(users.get(position));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {
        TextView tvUserName, tvUserUsername, tvUserEmail, tvUserPhone;
        Button btnUserPost, btnUserTodos;

        public UserViewHolder(View itemView) {
            super(itemView);
            tvUserName = itemView.findViewById(R.id.tvUserName);
            tvUserUsername = itemView.findViewById(R.id.tvUserUsername);
            tvUserEmail = itemView.findViewById(R.id.tvUserEmail);
            tvUserPhone = itemView.findViewById(R.id.tvUserPhone);
            btnUserPost = itemView.findViewById(R.id.btnUserPost);
            btnUserTodos = itemView.findViewById(R.id.btnUserTodos);
        }

        void bindView(final User user) {
            tvUserName.setText(user.getName());
            tvUserUsername.setText(user.getUsername());
            tvUserEmail.setText(user.getEmail());
            tvUserPhone.setText(user.getPhone());

            btnUserPost.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(context, PostsActivity.class);
                    i.putExtra("IdforPost", user.getId());
                    context.startActivity(i);
                }
            });

            btnUserTodos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(context, TodosActivity.class);
                    i.putExtra("IdforTodo", user.getId());
                    context.startActivity(i);
                }
            });
        }
    }
}
