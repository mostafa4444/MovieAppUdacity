package com.mostafa.root.retrofittesting.Fragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.mostafa.root.retrofittesting.Adapters.MoviesGridAdapter;
import com.mostafa.root.retrofittesting.Adapters.MoviesUpcomingGridAdapter;
import com.mostafa.root.retrofittesting.Model.MovieObj;
import com.mostafa.root.retrofittesting.Model.MovieObjUpcoming;
import com.mostafa.root.retrofittesting.Model.MovieResponse;
import com.mostafa.root.retrofittesting.Model.MovieResponseUpcoming;
import com.mostafa.root.retrofittesting.MovieDetailsActivity;
import com.mostafa.root.retrofittesting.R;
import com.mostafa.root.retrofittesting.WebServices.MovieGET;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UpcomingFragment extends Fragment{
    List<MovieObjUpcoming> movieObjUpcomings;
    GridView gridView;
    MoviesUpcomingGridAdapter adapter;
    public UpcomingFragment(){}
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.upcoming_fragment, container, false);
        gridView = rootView.findViewById(R.id.grid_upcoming_movie);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MovieObjUpcoming movieObj = movieObjUpcomings.get(position);
                Intent toDetail = new Intent(getActivity() , MovieDetailsActivity.class);
                toDetail.putExtra("movie_id", ""+movieObj.getMovie_id());
                toDetail.putExtra("movie_popularity",movieObj.getMovie_popularity());
                toDetail.putExtra("movie_rate",""+movieObj.getMovie_rate());
                toDetail.putExtra("movie_date",""+movieObj.getMovie_date());
                toDetail.putExtra("movie_poster","http://image.tmdb.org/t/p/w185/"+movieObj.getMovie_poster());
                toDetail.putExtra("movie_img","http://image.tmdb.org/t/p/w185/"+movieObj.getMovie_image());
                toDetail.putExtra("movie_description",movieObj.getMovie_description());
                toDetail.putExtra("movie_name",movieObj.getMovie_name());
                startActivity(toDetail);
            }
        });


        load_data();
        return rootView;
    }
    private void load_data(){
        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Waiting...");
        progressDialog.show();
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.themoviedb.org/3/movie/").addConverterFactory(GsonConverterFactory.create()).build();
        final MovieGET movieGET = retrofit.create(MovieGET.class);
        movieGET.getUpcomingMovies(getString(R.string.DB_API_TOKEN), "1").enqueue(new Callback<MovieResponseUpcoming>() {
            @Override
            public void onResponse(Call<MovieResponseUpcoming> call, Response<MovieResponseUpcoming> response) {
                progressDialog.dismiss();
                movieObjUpcomings= response.body().getResults();
                adapter = new MoviesUpcomingGridAdapter(getActivity(),R.layout.single_movie_design,movieObjUpcomings);
                gridView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<MovieResponseUpcoming> call, Throwable t) {

            }
        });
    }
}
