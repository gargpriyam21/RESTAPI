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
import com.example.neera.restapi.activites.PhotosActivity;
import com.example.neera.restapi.models.Album;

import java.util.ArrayList;

/**
 * Created by Neera on 26/09/17.
 */

public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.AlbumViewHolder> {

    ArrayList<Album> albums = new ArrayList<>();
    Context context;

    public AlbumsAdapter(Context context) {
        this.context = context;
    }

    public void updateAlbums(ArrayList<Album> albums) {
        this.albums = albums;
        notifyDataSetChanged();
    }

    @Override
    public AlbumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return new AlbumsAdapter.AlbumViewHolder(li.inflate(R.layout.list_item_album, parent, false));
    }

    @Override
    public void onBindViewHolder(AlbumViewHolder holder, int position) {
        holder.bindView(albums.get(position));
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }

    class AlbumViewHolder extends RecyclerView.ViewHolder {
        TextView tvAlbumTitle;
        LinearLayout llAlbums;

        public AlbumViewHolder(View itemView) {
            super(itemView);
            tvAlbumTitle = itemView.findViewById(R.id.tvAlbumTitle);
            llAlbums = itemView.findViewById(R.id.llAlbums);
        }

        void bindView(final Album album) {
            tvAlbumTitle.setText(album.getTitle());
            llAlbums.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(context, PhotosActivity.class);
                    i.putExtra("albumId", album.getId());
                    context.startActivity(i);
                }
            });
        }
    }
}
