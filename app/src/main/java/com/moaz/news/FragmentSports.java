package com.moaz.news;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
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

import com.moaz.news.newsmodels.NewsResponse;


public class FragmentSports extends Fragment {

    View thisFragment;
    RecyclerView myRecyclerView;
    RecyclerViewAdapter myAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        thisFragment = inflater.inflate(R.layout.fragment_sports, container, false);

        myRecyclerView = thisFragment.findViewById(R.id.recycler_view);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIInterface sportsCall = retrofit.create(APIInterface.class);

        sportsCall.getSportsNews().enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                myAdapter = new RecyclerViewAdapter(getContext(), response.body().getArticles());
                myRecyclerView.setAdapter(myAdapter);
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Loading Sports News Failed", Toast.LENGTH_SHORT).show();
            }
        });

        return thisFragment;
    }

}
