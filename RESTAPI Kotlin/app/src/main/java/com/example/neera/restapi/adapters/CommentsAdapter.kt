package com.example.neera.restapi.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.example.neera.restapi.R
import com.example.neera.restapi.models.Comment
import kotlinx.android.synthetic.main.list_item_comment.view.*

import java.util.ArrayList

/**
 * Created by Neera on 27/09/17.
 */

class CommentsAdapter(internal var context: Context) : RecyclerView.Adapter<CommentsAdapter.CommentViewHolder>() {
    internal var comments = ArrayList<Comment>()

    fun updatecomments(comments: ArrayList<Comment>) {
        this.comments = comments
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {

        val li = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        return CommentsAdapter.CommentViewHolder(li.inflate(R.layout.list_item_comment, parent, false))
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        holder.bindView(comments[position])
    }

    override fun getItemCount(): Int {
        return comments.size
    }

    class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvCommentName: TextView
        var tvCommentBody: TextView

        init {
            tvCommentName = itemView.findViewById(R.id.tvCommentName)
            tvCommentBody = itemView.findViewById(R.id.tvCommentBody)
        }

        fun bindView(comment: Comment) {
            tvCommentName.text = comment.name
            tvCommentBody.text = comment.body
        }
    }
}
