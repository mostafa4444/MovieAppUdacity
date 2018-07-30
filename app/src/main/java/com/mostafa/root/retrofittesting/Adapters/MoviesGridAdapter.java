package com.mostafa.root.retrofittesting.Adapters;

import android.app.Activity;
import android.arch.core.executor.TaskExecutor;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mostafa.root.retrofittesting.Model.MovieObj;
import com.mostafa.root.retrofittesting.MovieDetailsActivity;
import com.mostafa.root.retrofittesting.R;
import com.squareup.picasso.Picasso;
import java.util.List;

public class MoviesGridAdapter extends BaseAdapter {
    List <MovieObj> ArrayList;
    Context mContext;
    MovieObj mObject;
    int mResource;
    LayoutInflater inflater;

    public MoviesGridAdapter(Context context, int resource, List<MovieObj> ArrayList) {
        mContext =context;
        this.ArrayList=ArrayList;
        this.mResource = resource;

    }

    @Override
    public int getCount() {
        return ArrayList.size();

    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        inflater = LayoutInflater.from(mContext);
        mObject = ArrayList.get((int) getItemId(position));
        final View view = inflater.inflate(R.layout.single_movie_design, null);
        Picasso.get().load("http://image.tmdb.org/t/p/w185/"+mObject.getMovie_poster()).into((ImageView) view.findViewById(R.id.singe_img_movie));
        TextView film_name = (TextView) view.findViewById(R.id.film_name_single_txt);
        film_name.setText(mObject.getMovie_name());
        return view;
    }
}