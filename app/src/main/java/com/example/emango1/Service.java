package com.example.emango1;

import com.example.emango1.Pojo.Authorization;
import com.example.emango1.Pojo.CountryDetails;
import com.example.emango1.Pojo.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;

public class Service {
    private static final String URL = "https://testing.emango.global/";

    public static PostService postService;


    /**
     * API call
     *
     * @return - PostService
     */
    public static PostService getService() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        postService = retrofit.create(PostService.class);
        return postService;
    }

    /**
     * Interface used to call api (for now only used for GET)
     */

    public interface PostService {
        @POST("student/study-abroad-country-list-mobile/")
        Call<ArrayList<CountryDetails>> getDetails(@Body Authorization authorization);

        @POST("portal/trending-career/")
        Call<ArrayList<User>> getCareerDetails(@Body Authorization authorization);
    }
}
