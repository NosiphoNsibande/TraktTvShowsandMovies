package com.example.user1.trakttvshows.rest;

import com.example.user1.trakttvshows.model.MovieResponse;
import com.example.user1.trakttvshows.model.Shows;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ApiInterfaceShows {
    @GET("tv/popular")
    Call<Shows> getPopShows(@Query("api_key") String apiKey);

    //@GET("tv/popular?api_key=c94431cab6597dab45a1c126e000512f")
   // Call<Shows> getPopShows();

    @GET("tv/{id}")
    Call<Shows> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);
}
