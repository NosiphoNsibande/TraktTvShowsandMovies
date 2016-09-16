package com.example.user1.trakttvshows.rest;

import com.example.user1.trakttvshows.model.MovieResponse;
import com.example.user1.trakttvshows.model.Shows;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ApiInterface {
    @GET("movie/popular")
    Call<MovieResponse> getTopRatedMovies(@Query("api_key") String apiKey);

    @GET("movie/top_rated")
    Call<MovieResponse> getpopMovies(@Query("api_key") String apiKey);

    @GET("movie/upcoming")
    Call<MovieResponse> getTopRatedShows(@Query("api_key") String apiKey);

    @GET("movie/now_playing")
    Call<MovieResponse> getnowPlay(@Query("api_key") String apiKey);


    // @GET("movie/top_rated?api_key=c94431cab6597dab45a1c126e000512f")
    //Call<Shows> getPopShows();

    @GET("movie/{id}")
    Call<MovieResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);
}
