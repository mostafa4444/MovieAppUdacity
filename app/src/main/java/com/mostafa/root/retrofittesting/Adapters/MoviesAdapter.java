package com.mostafa.root.retrofittesting.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mostafa.root.retrofittesting.Model.MovieObj;
import com.mostafa.root.retrofittesting.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {
    private List<MovieObj> movieObjList;
    private Context context;


    public MoviesAdapter(List<MovieObj> movieObjList , Context context){
        this.movieObjList = movieObjList;
        this.context = context;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView movie_img;

        public ViewHolder(View itemView) {
            super(itemView);
            movie_img =  itemView.findViewById(R.id.singe_img_movie);
        }
    }
    public ViewHolder onCreateViewHolder(ViewGroup parent , int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate( R.layout.single_movie_design , parent ,false);
        return new ViewHolder(v);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder,final int position) {


//        holder.movie_description.setText(movieObjList.get(position).getMovie_description());
//        holder.movie_name.setText(movieObjList.get(position).getMovie_name());
        Picasso.get().load("http://image.tmdb.org/t/p/w185/"+movieObjList.get(position).getMovie_poster()).into(holder.movie_img);

    }
    @Override
    public int getItemCount() {
        return movieObjList.size();
    }
}
