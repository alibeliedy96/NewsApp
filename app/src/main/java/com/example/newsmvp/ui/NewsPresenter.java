package com.example.newsmvp.ui;


import com.example.newsmvp.Contracts.NewsContract;
import com.example.newsmvp.Model.NewsResponse.NewsResponse;

public class NewsPresenter implements NewsContract.NewsPresenter {

    NewsContract.NewsModel model;
    NewsContract.NewsView view;

    public NewsPresenter(NewsContract.NewsView view) {
        this.view = view;
        model=new NewsModel(this);
    }

    @Override
    public void getNews() {
        view.showLoading();
        model.getNewsFromApi("en");
    }

    @Override
    public void newsPrepared(NewsResponse newsResponse) {
        view.hideLoading();
        if(newsResponse==null){
            view.showMessage("Error","cannot get news");
        }else {
            view.showData(newsResponse.getArticles());
        }
    }
}
