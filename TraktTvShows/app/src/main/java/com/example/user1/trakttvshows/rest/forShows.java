package com.example.user1.trakttvshows.rest;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.user1.trakttvshows.MainActivity2;
import com.example.user1.trakttvshows.R;
import com.example.user1.trakttvshows.adapter.MoviesAdapter;
import com.example.user1.trakttvshows.adapter.ShowsAdapter;
import com.example.user1.trakttvshows.model.Movie;
import com.example.user1.trakttvshows.model.MovieResponse;
import com.example.user1.trakttvshows.model.Result;
import com.example.user1.trakttvshows.model.Shows;
import com.example.user1.trakttvshows.rest.ApiClient;
import com.example.user1.trakttvshows.rest.ApiInterface;
import com.example.user1.trakttvshows.rest.ApiInterfaceShows;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class forShows extends AppCompatActivity {

    private static final String TAG = MainActivity2.class.getSimpleName();
    // TODO - insert your themoviedb.org API KEY here
    private final static String API_KEY = "968cca12b1a8492036b1e1e05af57e3f";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showspop);

        if (API_KEY.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please obtain your API KEY from themoviedb.org first!", Toast.LENGTH_LONG).show();
            return;
        }

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.movies_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<MovieResponse> call = apiService.getTopRatedShows(API_KEY);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                int statusCode = response.code();
                List<Movie> mo = response.body().getResults();
                recyclerView.setAdapter(new MoviesAdapter(mo, R.layout.testing, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });

    }
}
