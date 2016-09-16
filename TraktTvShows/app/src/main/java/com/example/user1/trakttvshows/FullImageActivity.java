package com.example.user1.trakttvshows;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;


public class FullImageActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image);
        // get intent data
        Toolbar bar=(Toolbar) findViewById(R.id.toolbar);
        bar.setTitleTextColor(Color.WHITE);
        bar.setTitle("Trakt Tv Shows");

        Bundle extras = getIntent().getExtras();
        // Selected image id
        int position = extras.getInt("id");
        ImageAdapter imageAdapter = new ImageAdapter(this);
        ImageView imageView = (ImageView) findViewById(R.id.full_image_view);
        imageView.setImageResource(imageAdapter.mThumbIds[position]);

        TextView txtview=(TextView)findViewById(R.id.txtTitle);

        txtview.setText(imageAdapter.prgmNameList[position]);
    }

}