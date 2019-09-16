package com.example.neera.restapi.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

import com.example.neera.restapi.R
import com.example.neera.restapi.activites.CommentsActivity
import com.example.neera.restapi.models.Post

import java.util.ArrayList

/**
 * Created by Neera on 26/09/17.
 */

class PostsAdapter(internal var context: Context) : RecyclerView.Adapter<PostsAdapter.PostViewHolder>() {

    internal var posts = ArrayList<Post>()

    fun updatePosts(posts: ArrayList<Post>) {
        this.posts = posts
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val li = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        return PostsAdapter.PostViewHolder(li.inflate(R.layout.list_item_post, parent, false))
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bindView(posts[position])
    }


    override fun getItemCount(): Int {
        return posts.size
    }

    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tvPostTitle: TextView
        var tvPostBody: TextView
        var llPosts: LinearLayout

        init {
            tvPostBody = itemView.findViewById(R.id.tvPostBody)
            tvPostTitle = itemView.findViewById(R.id.tvPostTitle)
            llPosts = itemView.findViewById(R.id.llPosts)
        }

        fun bindView(post: Post) {
            tvPostBody.text = post.body
            tvPostTitle.text = post.title
            llPosts.setOnClickListener {
                val i = Intent(context, CommentsActivity::class.java)
                i.putExtra("postId", post.id)
                context.startActivity(i)
            }
        }
    }


}
