package com.example.user1.trakttvshows;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    TextView txtTitle;
    String [] result;
    // Keep all Images in array
    public  Integer[] mThumbIds = {
            R.drawable.prette, R.drawable.pic_2, R.drawable.theva, R.drawable.pic_4,
            R.drawable.pic_5, R.drawable.game, R.drawable.pic_7, R.drawable.pic_8,
            R.drawable.pic_9, R.drawable.pic_10, R.drawable.pic_11, R.drawable.pic_12,
            R.drawable.pic_14, R.drawable.pic_15, R.drawable.robort,
            R.drawable.viking, R.drawable.homeland, R.drawable.underthedom,
            R.drawable.bingbang, R.drawable.resid, R.drawable.lastship,
            R.drawable.thesim, R.drawable.oncesupon, R.drawable.twinpeaks,
    };
    public static String [] prgmNameList=
            {"Pretty Littie Liers","The 100",
                    "The vampire Diaries",
                    "The Originals",
                    "Arrow",
                    "Game Of Thrones",
                    "Into The Bad Lands",
                    "The Flash",
                    "X-Men",
                    "Dead Of Summer",
                    "Supergirl",
                    "Lost",
                    "Teen Wolf",
                    "X-Men: Apocalypse",
                    "Mr Robort",
                    "Vikings",
                    "Homeland",
                    "Under The Dome",
                    "Big Bang Theory",
                    "Residue",
                    "The Lastship",
                    "The Simpsons",
                    "Once Upon a time",
                    "Twin Peaks"
            };

    // Constructor
    public ImageAdapter(Context c){
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
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams((int)convertDpToPixel(85,mContext),(int)convertDpToPixel(85,mContext)));
        return imageView;



    }
    public static float convertDpToPixel(float dp, Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * ((float)metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return px;
    }
}
