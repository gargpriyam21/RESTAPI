package com.example.neera.restapi.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.neera.restapi.R;
import com.example.neera.restapi.models.Comment;

import java.util.ArrayList;

/**
 * Created by Neera on 27/09/17.
 */

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.CommentViewHolder> {
    ArrayList<Comment> comments = new ArrayList<>();
    Context context;

    public CommentsAdapter(Context context) {
        this.context = context;
    }

    public void updatecomments(ArrayList<Comment> comments) {
        this.comments = comments;
        notifyDataSetChanged();
    }

    @Override
    public CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return new CommentsAdapter.CommentViewHolder(li.inflate(R.layout.list_item_comment, parent, false));
    }

    @Override
    public void onBindViewHolder(CommentViewHolder holder, int position) {
        holder.bindView(comments.get(position));
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    class CommentViewHolder extends RecyclerView.ViewHolder {
        TextView tvCommentName, tvCommentBody;

        public CommentViewHolder(View itemView) {
            super(itemView);
            tvCommentName = itemView.findViewById(R.id.tvCommentName);
            tvCommentBody = itemView.findViewById(R.id.tvCommentBody);
        }

        void bindView(Comment comment) {
            tvCommentName.setText(comment.getName());
            tvCommentBody.setText(comment.getBody());
        }
    }
}
