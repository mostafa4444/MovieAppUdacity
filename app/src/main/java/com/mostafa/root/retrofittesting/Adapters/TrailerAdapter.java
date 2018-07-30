package com.mostafa.root.retrofittesting.Adapters;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mostafa.root.retrofittesting.Model.MovieObj;
import com.mostafa.root.retrofittesting.Model.TrailerObj;
import com.mostafa.root.retrofittesting.Model.TrailerResponse;
import com.mostafa.root.retrofittesting.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Callback;

public class TrailerAdapter extends RecyclerView.Adapter<TrailerAdapter.ViewHolder> {
    private List<TrailerObj> trailerObjList;
    private Context context;


    public TrailerAdapter(List<TrailerObj> trailerObjList , Context context){
        this.trailerObjList = trailerObjList;
        this.context = context;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView thum;
        public TextView t_name;

        public CardView open_trailer;

        public ViewHolder(View itemView) {
            super(itemView);
            thum =  itemView.findViewById(R.id.trailer_img);
            t_name = itemView.findViewById(R.id.trailer_title);
            open_trailer = itemView.findViewById(R.id.open_trailer);

        }
    }
    public TrailerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent , int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate( R.layout.single_trailer_design , parent ,false);
        return new TrailerAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.t_name.setText(trailerObjList.get(position).getName());
        final String id = trailerObjList.get(position).getKey();
        holder.open_trailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + id));
                Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=" + id));
                try {
                    context.startActivity(appIntent);
                } catch (ActivityNotFoundException ex) {
                    context.startActivity(webIntent);
                }
            }
        });


    }
    @Override
    public int getItemCount() {
        return trailerObjList.size();
    }
}