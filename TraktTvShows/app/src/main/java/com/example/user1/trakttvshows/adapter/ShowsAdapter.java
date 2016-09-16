package com.example.user1.trakttvshows.adapter;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ImageView;

import com.example.user1.trakttvshows.R;
import com.example.user1.trakttvshows.model.Movie;
import com.example.user1.trakttvshows.model.Result;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ShowsAdapter extends RecyclerView.Adapter<ShowsAdapter.MovieViewHolder> {

    private List<Result> popShows;
    private int rowLayout;
    private Context context;


    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        LinearLayout moviesLayout;
        TextView movieTitle;
        TextView data;
        ImageView imgImages;
        TextView movieDescription;
        TextView rating;


        public MovieViewHolder(View v) {
            super(v);
            moviesLayout = (LinearLayout) v.findViewById(R.id.movies_layout);
            movieTitle = (TextView) v.findViewById(R.id.title);
            data = (TextView) v.findViewById(R.id.subtitle);
            movieDescription = (TextView) v.findViewById(R.id.description);
            rating = (TextView) v.findViewById(R.id.rating);
            imgImages=(ImageView)v.findViewById(R.id.imgImages);

        }
    }

    public ShowsAdapter(List<Result> popShows, int rowLayout, Context context) {
        this.popShows = popShows;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public ShowsAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, final int position) {
        Context context =holder.imgImages.getContext();

        Picasso.with(holder.imgImages.getContext())
                .load("https://image.tmdb.org/t/p/w780"+popShows.get(position).getPosterPath()).
                into(holder.imgImages);

        holder.movieTitle.setText(popShows.get(position).getOriginalName());
        holder.imgImages.setBackgroundColor(Color.GRAY);

        holder.movieTitle.setTextColor(Color.WHITE);

        holder.data.setText(popShows.get(position).getFirstAirDate());
        holder.movieDescription.setText(popShows.get(position).getOverview());

    }

    @Override
    public int getItemCount() {
        return popShows.size();
    }
}
