package com.example.neera.restapi.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.example.neera.restapi.R
import com.example.neera.restapi.models.Photo
import com.squareup.picasso.Picasso

import java.io.IOException
import java.net.URISyntaxException
import java.net.URL
import java.util.ArrayList

/**
 * Created by Neera on 27/09/17.
 */

class PhotosAdapter(internal var context: Context) : RecyclerView.Adapter<PhotosAdapter.PhotoViewHolder>() {
    internal var photos = ArrayList<Photo>()

    fun updatephotos(photos: ArrayList<Photo>) {
        this.photos = photos
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val li = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        return PhotosAdapter.PhotoViewHolder(li.inflate(R.layout.list_item_photo, parent, false))
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        try {
            holder.bindView(photos[position])
        } catch (e: URISyntaxException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }

    override fun getItemCount(): Int {
        return photos.size
    }


    class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivPhoto: ImageView
        var tvPhotoTitle: TextView

        init {
            tvPhotoTitle = itemView.findViewById(R.id.tvPhotoTitle)
            ivPhoto = itemView.findViewById(R.id.ivPhoto)
        }

        @Throws(IOException::class, URISyntaxException::class)
        fun bindView(photo: Photo) {
            val url = photo.url
            tvPhotoTitle.text = photo.title
            //ivPhoto.setImageBitmap(BitmapFactory.decodeStream(url.openConnection().getInputStream()));
            Picasso.with(context).load(url.toURI().toString()).into(ivPhoto)
        }
    }
}
