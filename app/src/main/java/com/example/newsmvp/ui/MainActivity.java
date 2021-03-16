package com.example.newsmvp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.newsmvp.Adapters.NewsAdapter;
import com.example.newsmvp.Base.BaseActivity;
import com.example.newsmvp.Contracts.NewsContract;
import com.example.newsmvp.Model.NewsResponse.ArticlesItem;
import com.example.newsmvp.R;

import java.util.List;

public class MainActivity extends BaseActivity implements NewsContract.NewsView {
   NewsContract.NewsPresenter presenter;
   RecyclerView recyclerView;
   NewsAdapter adapter;
   RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter=new NewsPresenter(this);
        presenter.getNews();
        recyclerView=findViewById(R.id.recycler_view);
        adapter=new NewsAdapter(null);
        layoutManager=new LinearLayoutManager(activity);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void showLoading() {
        showProgressBar(R.string.loading);
    }

    @Override
    public void hideLoading() {
       hideProgressBar();
    }

    @Override
    public void showMessage(String title, String content) {
        showMessage(title,content,getString(R.string.ok));
    }

    @Override
    public void showData(List<ArticlesItem> newsList) {
        adapter.changeData(newsList);
    }
}