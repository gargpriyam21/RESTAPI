package com.example.neera.restapi.models;

/**
 * Created by Neera on 26/09/17.
 */

public class Todo {

    private int id;
    private int userId;
    private String title;
    private boolean completed;

    public Todo(int id, int userId, String title, boolean completed) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }
}
