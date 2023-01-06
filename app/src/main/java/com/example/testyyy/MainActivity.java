package com.example.testyyy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView t = findViewById(R.id.aaaa);
        OkHttpClient.Builder ohc = new OkHttpClient.Builder();



        Retrofit.Builder bl = new Retrofit.Builder().baseUrl("https://api.github.com/").addConverterFactory(
                GsonConverterFactory.create()
        );

        Retrofit rf = bl.build();
        /*
        Retrofit isa = new Retrofit.Builder().baseUrl("https://api.github.com/").addConverterFactory(
                GsonConverterFactory.create()
        ).build();

        */

        RFInterface rfif = rf.create(RFInterface.class);

        Call<List<GHRepos>> call =rfif.reposUser("fs-opensource");

        call.enqueue(new Callback<List<GHRepos>>() {
            int i = 0;
            @Override
            public void onResponse(Call<List<GHRepos>> call, Response<List<GHRepos>> response) {
                List<GHRepos> ll = response.body();

                /*while (i<ll.size())
                {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            t.setText(ll.get(i).toString());

                        }
                    },2000);
                    i++;
                }*/


            }

            @Override
            public void onFailure(Call<List<GHRepos>> call, Throwable t) {

            }
        });

    }
}