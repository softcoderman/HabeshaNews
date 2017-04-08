package com.gebeya.habeshanews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class ListArticleActivity extends AppCompatActivity
        implements ArticleAdapter.ItemClickListner {

    ArticleAdapter articleAdapter;
    RecyclerView   recyclerView;
    ArrayList<Article> listArticles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_article);

        recyclerView =  (RecyclerView) findViewById(R.id.rv_articles);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        listArticles = Article.getArticles();
        articleAdapter = new ArticleAdapter(listArticles, this);
        recyclerView.setAdapter(articleAdapter);
    }



    @Override
    public void onItemClick(int adapterPosition) {
        Intent startDetailActivity  = new Intent(getApplicationContext(), DetaileActivity.class);
        //Article article = listArticles.get(position);
        //tartDetailActivity.putExtra("Article", article);
       getApplicationContext().startActivity(startDetailActivity);
    }
}
