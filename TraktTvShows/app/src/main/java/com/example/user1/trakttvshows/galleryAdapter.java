package com.example.user1.trakttvshows;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


public class galleryAdapter extends BaseAdapter {
    private Context mContext;
    int[] mThumbIds = {R.drawable.game,
            R.drawable.pic_21,
            R.drawable.prette,
            R.drawable.viking,
            R.drawable.stranger,
            R.drawable.pic_5,
            R.drawable.pic_14,
            R.drawable.prison,
            R.drawable.robort,
            R.drawable.pic_4,};

    public galleryAdapter(Context c){
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
       // imageView.setImageResource(mThumbIds[position]);
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
