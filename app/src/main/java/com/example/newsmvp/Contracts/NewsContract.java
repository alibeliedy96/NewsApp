package com.example.newsmvp.Contracts;


import com.example.newsmvp.Model.NewsResponse.ArticlesItem;
import com.example.newsmvp.Model.NewsResponse.NewsResponse;

import java.util.List;

public class NewsContract {
    //responsible of getting data from api
    //just connect with presenter
    public interface NewsModel{
        void getNewsFromApi(String lang);
    }
    //responsible of show data in view
    //just connect with presenter
    public interface NewsView{
         void showLoading();
         void hideLoading();
         void showMessage(String title, String content);
         void showData(List<ArticlesItem> newsList);
    }
    //the road between model and view
    public interface NewsPresenter{
       void getNews();
       void newsPrepared(NewsResponse newsResponse);
    }
}
