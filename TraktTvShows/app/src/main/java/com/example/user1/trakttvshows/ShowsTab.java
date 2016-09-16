package com.example.user1.trakttvshows;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Button;

import com.example.user1.trakttvshows.rest.forShows;


public class ShowsTab extends Fragment {

    Gallery simpleGallery;
    Gallery simpleGallery2;
    Gallery simpleGallery3;
    CustomGalleryAdapter customGalleryAdapter;
    Button more;
    Button more2;
    ImageView selectedImageView;

    private galleryAdapter adapter;

    public ShowsTab() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_shows_tab, container, false);
        simpleGallery = (Gallery) rootView.findViewById(R.id.simpleGallery); // get the reference of Gallery
        simpleGallery2=(Gallery) rootView.findViewById(R.id.simpleGallery2);
        simpleGallery3=(Gallery) rootView.findViewById(R.id.simpleGallery3);

        more=(Button) rootView.findViewById(R.id.more);
        more.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),forShows.class);
                startActivity(intent);
            }
        });

        more2=(Button) rootView.findViewById(R.id.more2);
        more2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),MainActivity2.class);
                startActivity(intent);
            }
        });

      Button  more3=(Button) rootView.findViewById(R.id.more3);
        more3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),playingMovies.class);
                startActivity(intent);
            }
        });


        selectedImageView = (ImageView)rootView.findViewById(R.id.selectedImageView);
        simpleGallery.setAdapter(new galleryAdapter(getActivity())); // set the adapter
        simpleGallery2.setAdapter(new TredGalleyAdapter(getActivity()));
        simpleGallery3.setAdapter(new PlayeAdapter(getActivity()));

        simpleGallery.setSpacing(0);
        //simpleGallery2.setSpacing(2);
        simpleGallery3.setSpacing(0);

        simpleGallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // set the selected image in the ImageView
                Intent i = new Intent(getActivity().getApplicationContext(), FullImageActivity.class);
                // passing array index
                i.putExtra("id", position);
                startActivity(i);
            }
        });
        return rootView;
    }
}
