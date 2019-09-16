package com.example.neera.restapi.models;

import java.net.URL;

/**
 * Created by Neera on 27/09/17.
 */

public class Photo {
    private int albumId;
    private int id;
    private String title;
    private URL url;

    public Photo(int albumId, int id, String title, URL url) {
        this.albumId = albumId;
        this.id = id;
        this.title = title;
        this.url = url;
    }

    public int getAlbumId() {
        return albumId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public URL getUrl() {
        return url;
    }
}
