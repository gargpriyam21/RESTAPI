package com.example.neera.restapi.api;


import com.example.neera.restapi.models.Album;
import com.example.neera.restapi.models.Comment;
import com.example.neera.restapi.models.Photo;
import com.example.neera.restapi.models.Post;
import com.example.neera.restapi.models.Todo;
import com.example.neera.restapi.models.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


/**
 * Created by Neera on 27/09/17.
 */

public interface API {


    @GET("/users")
    Call<ArrayList<User>> getUsers();

    @GET("/posts")
    Call<ArrayList<Post>> getPosts();

    @GET("/albums")
    Call<ArrayList<Album>> getAlbums();

    @GET("/todos")
    Call<ArrayList<Todo>> getTodos();

    @GET("/posts/{id}/comments")
    Call<ArrayList<Comment>> getComments(@Path("id") int id);

    @GET("/albums/{id}/photos")
    Call<ArrayList<Photo>> getphotos(@Path("id") int id);

    @GET("/posts")
    Call<ArrayList<Post>> GetPostOfUser(@Query("userId") int userId);

    @GET("/todos")
    Call<ArrayList<Todo>> GetTodoOfUser(@Query("userId") int userId);
}
