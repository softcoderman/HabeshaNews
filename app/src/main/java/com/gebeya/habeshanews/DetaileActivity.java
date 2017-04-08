package com.gebeya.habeshanews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class DetaileActivity extends AppCompatActivity {

    private TextView articleTitleText;
    private TextView articleDateText;
    private TextView articleContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detaile);

        articleTitleText  = (TextView) findViewById(R.id.article_title) ;
        articleDateText  = (TextView) findViewById(R.id.article_date) ;
        articleContent  = (TextView) findViewById(R.id.article_content) ;


        Intent intent  = getIntent();

        Article article = intent.getExtras().getParcelable("Article");

        articleTitleText.setText(article.getTitle());
        articleDateText.setText(article.getDate());
        articleContent.setText(article.getArticleContent());



    }
}
