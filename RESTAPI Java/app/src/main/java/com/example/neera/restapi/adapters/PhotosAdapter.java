package com.example.neera.restapi.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.neera.restapi.R;
import com.example.neera.restapi.models.Photo;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Neera on 27/09/17.
 */

public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.PhotoViewHolder> {
    ArrayList<Photo> photos = new ArrayList<>();
    Context context;

    public PhotosAdapter(Context context) {
        this.context = context;
    }

    public void updatephotos(ArrayList<Photo> photos) {
        this.photos = photos;
        notifyDataSetChanged();
    }

    @Override
    public PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return new PhotosAdapter.PhotoViewHolder(li.inflate(R.layout.list_item_photo, parent, false));
    }

    @Override
    public void onBindViewHolder(PhotoViewHolder holder, int position) {
        try {
            holder.bindView(photos.get(position));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }


    class PhotoViewHolder extends RecyclerView.ViewHolder {
        ImageView ivPhoto;
        TextView tvPhotoTitle;

        public PhotoViewHolder(View itemView) {
            super(itemView);
            tvPhotoTitle = itemView.findViewById(R.id.tvPhotoTitle);
            ivPhoto = itemView.findViewById(R.id.ivPhoto);
        }

        void bindView(Photo photo) throws IOException, URISyntaxException {
            URL url = photo.getUrl();
            tvPhotoTitle.setText(photo.getTitle());
            //ivPhoto.setImageBitmap(BitmapFactory.decodeStream(url.openConnection().getInputStream()));
            Picasso.with(context).load(String.valueOf(url.toURI())).into(ivPhoto);
        }
    }
}
