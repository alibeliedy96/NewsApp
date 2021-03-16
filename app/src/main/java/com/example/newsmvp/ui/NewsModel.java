package com.example.newsmvp.ui;

import com.example.newsmvp.API.ApiManager;
import com.example.newsmvp.Contracts.NewsContract;
import com.example.newsmvp.Model.NewsResponse.NewsResponse;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class NewsModel implements NewsContract.NewsModel {

    public static final String APIKEY = "a5397c59d2c84efd9d728e71b8dae98b";
    NewsContract.NewsPresenter presenter;

    public NewsModel(NewsContract.NewsPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void getNewsFromApi(String lang) {
        ApiManager.getAPIs()
                .getNewsBySourceId(APIKEY,lang,"abc-news")
                .enqueue(new Callback<NewsResponse>() {
                    @Override
                    public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                        presenter.newsPrepared(response.body());
                    }

                    @Override
                    public void onFailure(Call<NewsResponse> call, Throwable t) {
                        presenter.newsPrepared(null);
                    }
                });

    }
}
