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
import com.example.neera.restapi.activites.PhotosActivity
import com.example.neera.restapi.models.Album

import java.util.ArrayList

/**
 * Created by Neera on 26/09/17.
 */

class AlbumsAdapter(internal var context: Context) : RecyclerView.Adapter<AlbumsAdapter.AlbumViewHolder>() {

    internal var albums = ArrayList<Album>()

    fun updateAlbums(albums: ArrayList<Album>) {
        this.albums = albums
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val li = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        return AlbumsAdapter.AlbumViewHolder(li.inflate(R.layout.list_item_album, parent, false))
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.bindView(albums[position])
    }

    override fun getItemCount(): Int {
        return albums.size
    }

    class AlbumViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvAlbumTitle: TextView
        var llAlbums: LinearLayout

        init {
            tvAlbumTitle = itemView.findViewById(R.id.tvAlbumTitle)
            llAlbums = itemView.findViewById(R.id.llAlbums)
        }

        fun bindView(album: Album) {
            tvAlbumTitle.text = album.title
            llAlbums.setOnClickListener {
                val i = Intent(context, PhotosActivity::class.java)
                i.putExtra("albumId", album.id)
                context.startActivity(i)
            }
        }
    }
}
