package com.example.user1.trakttvshows;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class PlayeAdapter extends BaseAdapter {
    private Context mContext;
    int[] mThumbIds = {R.drawable.bingbang,
            R.drawable.resid,
            R.drawable.lastship,
            R.drawable.thesim,
            R.drawable.oncesupon,
            R.drawable.lina,
            R.drawable.underthedom,
            R.drawable.twinpeaks,
            R.drawable.thetrain,
            R.drawable.thereturn,};

    public PlayeAdapter(Context c){
        mContext = c;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return mThumbIds[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        Picasso.with(imageView.getContext())
                .load(mThumbIds[position])
                .fit()
                .into(imageView);
        //imageView.setImageResource(mThumbIds[position]);
        imageView.setLayoutParams(new Gallery.LayoutParams(230, 230));
        return imageView;
    }

}
