package com.example.neera.restapi.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Neera on 27/09/17.
 */

public class ApiService {
    private static API api = null;

    private ApiService() {
    }

    public static API getAPI() {
        if (api == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            api = retrofit.create(API.class);
        }

        return api;
    }

}
