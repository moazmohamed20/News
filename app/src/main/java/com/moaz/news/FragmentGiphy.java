package com.moaz.news;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.moaz.news.giphymodels.News;

public class FragmentGiphy extends Fragment {

    View thisFragment;
    RecyclerView myRecyclerView;
    GifsRecyclerViewAdapter myAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        thisFragment = inflater.inflate(R.layout.fragment_giphy, container, false);

        myRecyclerView = thisFragment.findViewById(R.id.recycler_view);
        myRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.giphy.com/v1/gifs/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIInterface giphy = retrofit.create(APIInterface.class);

        giphy.getGifs().enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                myAdapter = new GifsRecyclerViewAdapter(getContext(), response.body().getData());
                myRecyclerView.setAdapter(myAdapter);
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {
                Toast.makeText(getContext(), "Loading Gifs Failed", Toast.LENGTH_SHORT).show();
            }
        });

        return thisFragment;
    }

}
