package com.example.user1.trakttvshows;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class TredGalleyAdapter extends BaseAdapter {
    private Context mContext;
    int[] mThumbIds = {R.drawable.homeland,
            R.drawable.t1,
            R.drawable.t2,
            R.drawable.sherlock,
            R.drawable.myarro,
            R.drawable.trones,
            R.drawable.myflash,
            R.drawable.dexter,
            R.drawable.cont,
            R.drawable.marv,};

    public TredGalleyAdapter(Context c){
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
        imageView.setImageResource(mThumbIds[position]);
       // imageView.setLayoutParams(new Gallery.LayoutParams(230, 230));
        imageView.setLayoutParams(new Gallery.LayoutParams((int)convertDpToPixel(200,mContext),(int)convertDpToPixel(200,mContext)));
        return imageView;
    }
    public static float convertDpToPixel(float dp, Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * ((float)metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return px;
    }
}
