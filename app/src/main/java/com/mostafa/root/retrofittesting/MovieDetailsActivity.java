package com.mostafa.root.retrofittesting;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mostafa.root.retrofittesting.Adapters.MoviesGridAdapter;
import com.mostafa.root.retrofittesting.Adapters.ReviewAdapter;
import com.mostafa.root.retrofittesting.Adapters.TrailerAdapter;
import com.mostafa.root.retrofittesting.Model.MovieDatabaseHelper;
import com.mostafa.root.retrofittesting.Model.MovieDatabaseModel;
import com.mostafa.root.retrofittesting.Model.MovieObj;
import com.mostafa.root.retrofittesting.Model.MovieResponse;
import com.mostafa.root.retrofittesting.Model.ReviewObj;
import com.mostafa.root.retrofittesting.Model.ReviewResponse;
import com.mostafa.root.retrofittesting.Model.TrailerObj;
import com.mostafa.root.retrofittesting.Model.TrailerResponse;
import com.mostafa.root.retrofittesting.WebServices.MovieGET;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieDetailsActivity extends AppCompatActivity {

    private List<TrailerObj> trailerObjs;
    private List<ReviewObj> reviewObj;
    private ImageView img_default_film , img_poster_film , img_rate1 , img_rate2 , img_rate3 , img_rate4 , img_rate5 , img_favorite_film;
    private boolean isFavorite = false;
    private TextView film_name_txt  , rate_average_txt , date_film_txt , description_content_txt , no_review_txt;
    private String id , popularity , movie_rate , movie_date , movie_poster , movie_img , movie_description , movie_name;
    private RecyclerView trailers_recycler , review_recycler;
    private ReviewAdapter reviewAdapter;
    private TrailerAdapter trailerAdapter;
    MovieDatabaseHelper checkFav = new MovieDatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        init();
    }

    private void init(){
        img_default_film = findViewById(R.id.detail_film_img);
        img_poster_film = findViewById(R.id.detail_film_poster);
        img_rate1 = findViewById(R.id.detail_level1);
        img_rate2 = findViewById(R.id.detail_level2);
        img_rate3 = findViewById(R.id.detail_level3);
        img_rate4 = findViewById(R.id.detail_level4);
        img_rate5 = findViewById(R.id.detail_level5);
        img_favorite_film = findViewById(R.id.img_film_favorite);
        film_name_txt = findViewById(R.id.detail_film_name_txt);
        rate_average_txt = findViewById(R.id.detail_film_rate_mark_txt);
        date_film_txt = findViewById(R.id.detail_film_date_txt);
        description_content_txt = findViewById(R.id.detail_film_description_txt);
        review_recycler = findViewById(R.id.detail_recycler_film_reviews);
        no_review_txt = findViewById(R.id.txt_no_review);
        trailers_recycler = findViewById(R.id.recycler_film_trailer_videos);
        review_recycler.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        review_recycler.setLayoutManager(linearLayoutManager);
        trailers_recycler.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        trailers_recycler.setLayoutManager(layoutManager);
        getExtraString();
        viewExtraData();
        isFavorite = checkFav.checkIsFilmFavorite(id);
        if(isFavorite){
            img_favorite_film.setImageResource(R.drawable.fav);
            isFavorite = true;
        }else{
            img_favorite_film.setImageResource(R.drawable.whiteheart);
            isFavorite = false;
        }
        favorite_image_click();
    }

    private void favorite_image_click(){
        img_favorite_film.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isFavorite){
                    isFavorite = false;
                    deleteFromFavorite(id);
                    img_favorite_film.setImageResource(R.drawable.whiteheart);
                }else{
                    isFavorite = true;
                    insertMovieToFavorite(id);
                    img_favorite_film.setImageResource(R.drawable.fav);
                }
            }
        });
    }

    private void getExtraString(){
        id = getIntent().getStringExtra("movie_id");
        popularity = getIntent().getStringExtra("movie_popularity");
        movie_rate = getIntent().getStringExtra("movie_rate");
        movie_date = getIntent().getStringExtra("movie_date");
        movie_poster = getIntent().getStringExtra("movie_poster");
        movie_img = getIntent().getStringExtra("movie_img");
        movie_description = getIntent().getStringExtra("movie_description");
        movie_name = getIntent().getStringExtra("movie_name");

    }
    private void viewExtraData(){
        Picasso.get().load(movie_poster).into((img_poster_film));
        Picasso.get().load(movie_img).into((img_default_film));
        film_name_txt.setText(movie_name);
        description_content_txt.setText(movie_description);
        date_film_txt.setText(movie_date);
        rate_average_txt.setText(movie_rate+ " / 10");
        rate_film_level(movie_rate);
        getReviews();
        getTrailers();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(MovieDetailsActivity.this , WelcomeActivity.class)); finish();
    }
    private void rate_film_level(String rate){
        Double value = Double.parseDouble(rate);
        if(value <= 2.0){
            img_rate1.setImageResource(R.drawable.start);
        }else if(value > 2.0 && value <= 4.0){
            img_rate1.setImageResource(R.drawable.start);
            img_rate2.setImageResource(R.drawable.start);
        }else if(value > 4.0 && value <= 7.0){
            img_rate1.setImageResource(R.drawable.start);
            img_rate2.setImageResource(R.drawable.start);
            img_rate3.setImageResource(R.drawable.start);
        }else if(value > 7.0 && value <= 9.0){
            img_rate1.setImageResource(R.drawable.start);
            img_rate2.setImageResource(R.drawable.start);
            img_rate3.setImageResource(R.drawable.start);
            img_rate4.setImageResource(R.drawable.start);

        }else if(value > 9.0 &&  value <= 10.0){
            img_rate1.setImageResource(R.drawable.start);
            img_rate2.setImageResource(R.drawable.start);
            img_rate3.setImageResource(R.drawable.start);
            img_rate4.setImageResource(R.drawable.start);
            img_rate5.setImageResource(R.drawable.start);
        }
    }
    private void toast_short(String msg){
        Toast.makeText(getApplicationContext(), ""+msg, Toast.LENGTH_SHORT).show();
    }
    private void toast_long(String msg){
        Toast.makeText(getApplicationContext(), ""+msg, Toast.LENGTH_LONG).show();
    }

    private void getReviews(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.themoviedb.org/").addConverterFactory(GsonConverterFactory.create()).build();
        final MovieGET movieGET = retrofit.create(MovieGET.class);
        movieGET.findReviewsById(Long.parseLong(id),getString(R.string.DB_API_TOKEN )).enqueue(new Callback<ReviewResponse>() {
            @Override
            public void onResponse(Call<ReviewResponse> call, Response<ReviewResponse> response) {
                reviewObj = response.body().getReviews();
                if (reviewObj != null && !reviewObj.isEmpty()) {
                    reviewAdapter = new ReviewAdapter(reviewObj , MovieDetailsActivity.this);
                    review_recycler.setAdapter(reviewAdapter);
                }else{
                    review_recycler.setVisibility(View.GONE);
                    no_review_txt.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<ReviewResponse> call, Throwable t) {

            }
        });
    }

    private void getTrailers(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.themoviedb.org/").addConverterFactory(GsonConverterFactory.create()).build();
        final MovieGET movieGET = retrofit.create(MovieGET.class);
        movieGET.getMovieTrailers(id ,getString(R.string.DB_API_TOKEN )).enqueue(new Callback<TrailerResponse>() {
            @Override
            public void onResponse(Call<TrailerResponse> call, Response<TrailerResponse> response) {
                trailerObjs = response.body().getTrailers();
                trailerAdapter = new TrailerAdapter(trailerObjs , MovieDetailsActivity.this);
                trailers_recycler.setAdapter(trailerAdapter);
            }

            @Override
            public void onFailure(Call<TrailerResponse> call, Throwable t) {
                toast_long(t.getMessage().toString());
            }
        });
    }

    public void insertMovieToFavorite(String id){
        MovieDatabaseHelper db = new MovieDatabaseHelper(MovieDetailsActivity.this);
        db.addMovieToFavorite(new MovieDatabaseModel(id , movie_name  , movie_img , movie_poster , movie_rate , movie_date));
        Toast.makeText(MovieDetailsActivity.this , "Movie Added To Favorite List" , Toast.LENGTH_SHORT).show();
    }

    public void deleteFromFavorite(String id){
        MovieDatabaseHelper db = new MovieDatabaseHelper(MovieDetailsActivity.this);
        db.deleteFromFavorite(id);
        Toast.makeText(MovieDetailsActivity.this , "Movie Removed From Favorite List" , Toast.LENGTH_SHORT).show();
    }

}

