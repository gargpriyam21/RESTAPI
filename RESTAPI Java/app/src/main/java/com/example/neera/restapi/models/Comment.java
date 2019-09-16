package com.example.neera.restapi.models;

/**
 * Created by Neera on 27/09/17.
 */

public class Comment {
    private int postId;
    private int id;
    private String name;
    private String body;

    public Comment(int postId, int id, String name, String body) {
        this.postId = postId;
        this.id = id;
        this.name = name;
        this.body = body;
    }

    public int getPostId() {
        return postId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBody() {
        return body;
    }
}
