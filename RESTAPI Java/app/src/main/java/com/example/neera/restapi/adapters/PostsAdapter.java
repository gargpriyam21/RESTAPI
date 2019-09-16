package com.example.neera.restapi.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.neera.restapi.R;
import com.example.neera.restapi.activites.CommentsActivity;
import com.example.neera.restapi.models.Post;

import java.util.ArrayList;

/**
 * Created by Neera on 26/09/17.
 */

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostViewHolder> {

    ArrayList<Post> posts = new ArrayList<>();
    Context context;

    public PostsAdapter(Context context) {
        this.context = context;
    }

    public void updatePosts(ArrayList<Post> posts) {
        this.posts = posts;
        notifyDataSetChanged();
    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return new PostsAdapter.PostViewHolder(li.inflate(R.layout.list_item_post, parent, false));
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        holder.bindView(posts.get(position));
    }


    @Override
    public int getItemCount() {
        return posts.size();
    }

    class PostViewHolder extends RecyclerView.ViewHolder {

        TextView tvPostTitle, tvPostBody;
        LinearLayout llPosts;

        public PostViewHolder(View itemView) {
            super(itemView);
            tvPostBody = itemView.findViewById(R.id.tvPostBody);
            tvPostTitle = itemView.findViewById(R.id.tvPostTitle);
            llPosts = itemView.findViewById(R.id.llPosts);
        }

        void bindView(final Post post) {
            tvPostBody.setText(post.getBody());
            tvPostTitle.setText(post.getTitle());
            llPosts.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(context, CommentsActivity.class);
                    i.putExtra("postId", post.getId());
                    context.startActivity(i);
                }
            });
        }
    }


}
