package com.moaz.news;

import com.moaz.news.giphymodels.News;
import com.moaz.news.newsmodels.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {
    @GET("top-headlines?country=us&category=sports&apiKey=c4652d58322344a783a6cea9e37e0707")
    Call<NewsResponse> getSportsNews();

    @GET("top-headlines?country=us&category=technology&apiKey=c4652d58322344a783a6cea9e37e0707")
    Call<NewsResponse> getTechnologyNews();

    @GET("trending?api_key=dUM9Yg2XTLNt4WOcmAyXFWsocyruyHjP")
    Call<News> getGifs();
}
