package com.mostafa.root.retrofittesting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mostafa.root.retrofittesting.WebServices.BlogServices;
import com.mostafa.root.retrofittesting.WebServices.PostsServices;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


//
//    private void load_data() {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                String URL_DATA = "https://jsonplaceholder.typicode.com/posts";
//                try {
//                    URL url = new URL(URL_DATA);
//                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
//                    InputStream inputStream = urlConnection.getInputStream();
//                    int c = 0;
//                    StringBuffer buffer = new StringBuffer();
//                    while ((c=inputStream.read()) != -1){
//                        buffer.append((char) c);
//                    }
//                    final String result = buffer.toString();
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            txt_data.setText(result);
//                        }
//                    });
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//    }
//
//    private void load_data_Retro() {
//        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/").build();
//        PostsServices postsServices = retrofit.create(PostsServices.class);
//        postsServices.getPosts().enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
////                txt_data.setText(response.body().toString());
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                Toast.makeText(MainActivity.this, ""+t.toString(), Toast.LENGTH_SHORT).show();
//
//            }
//        });
//    }
//
//    private void postExample(){
//        String URL_DATA = "https://jsonplaceholder.typicode.com/";
//        Retrofit retrofit = new Retrofit.Builder().baseUrl(URL_DATA).build();
//        BlogServices blogServices = retrofit.create(BlogServices.class);
//        blogServices.createNewPost("" , "" , 1).enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//
//            }
//        });
//    }



}
