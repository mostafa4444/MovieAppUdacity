package com.mostafa.root.retrofittesting.Fragments;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Movie;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.mostafa.root.retrofittesting.Adapters.MoviesAdapter;
import com.mostafa.root.retrofittesting.Adapters.MoviesGridAdapter;
import com.mostafa.root.retrofittesting.Classess.EndlessScrollListener;
import com.mostafa.root.retrofittesting.Model.MovieObj;
import com.mostafa.root.retrofittesting.Model.MovieResponse;
import com.mostafa.root.retrofittesting.MovieDetailsActivity;
import com.mostafa.root.retrofittesting.R;
import com.mostafa.root.retrofittesting.WebServices.MovieGET;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class PopularMovieFragment extends Fragment{
    List<MovieObj> movieObjs;
    GridView gridView;
    int my_page = 1;
    MoviesGridAdapter adapter;
    public PopularMovieFragment(){}
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.popular_movie_fragment, container, false);
        gridView = rootView.findViewById(R.id.grid_popular_movie);
        load_data(1);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MovieObj movieObj = movieObjs.get(position);
                Intent toDetail = new Intent(getActivity() , MovieDetailsActivity.class);
                toDetail.putExtra("movie_id", ""+movieObj.getMovie_id());
                toDetail.putExtra("movie_popularity",movieObj.getPopularity());
                toDetail.putExtra("movie_rate",""+movieObj.getMovie_rate());
                toDetail.putExtra("movie_date",""+movieObj.getMovie_date());
                toDetail.putExtra("movie_poster","http://image.tmdb.org/t/p/w185/"+movieObj.getMovie_poster());
                toDetail.putExtra("movie_img","http://image.tmdb.org/t/p/w185/"+movieObj.getMovie_image());
                toDetail.putExtra("movie_description",movieObj.getMovie_description());
                toDetail.putExtra("movie_name",movieObj.getMovie_name());
                startActivity(toDetail);
            }
        });
        return rootView;
    }

    private void loadmore(int page){
        load_data(page);
    }
    private void load_data(int page){
        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Waiting...");
        progressDialog.show();
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.themoviedb.org/3/movie/").addConverterFactory(GsonConverterFactory.create()).build();
        final MovieGET movieGET = retrofit.create(MovieGET.class);
        movieGET.getPopularMovies(getString(R.string.DB_API_TOKEN ), String.valueOf(page)).enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                progressDialog.dismiss();
                movieObjs = response.body().getResults();
                adapter = new MoviesGridAdapter(getActivity(),R.layout.single_movie_design,movieObjs);
                gridView.setAdapter(adapter);
            }
            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
            }
        });
    }
}
