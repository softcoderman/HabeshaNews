package com.gebeya.habeshanews;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by gebeya-admin on 4/8/17.
 */

public class Article implements Parcelable {

      long  id;
     String title;
     String date;
    String  articleContent;

    public Article(long id, String title, String date, String articleContent) {
        this.id = id;
        this.title = title;
        this.date = date;
        this. articleContent = articleContent;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    protected Article(Parcel in) {
        id = in.readLong();
        title = in.readString();
        date = in.readString();
        articleContent = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(title);
        dest.writeString(date);
        dest.writeString(articleContent);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Article> CREATOR = new Creator<Article>() {
        @Override
        public Article createFromParcel(Parcel in) {
            return new Article(in);
        }

        @Override
        public Article[] newArray(int size) {
            return new Article[size];
        }
    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public static ArrayList<Article> getArticles(){

        ArrayList<Article>  newArticles = new ArrayList<>();

        newArticles.add(new Article(1, "Mobiles",
                DateFormat.getDateTimeInstance().format(new Date()),"mobiles in the market now are goood"));

        newArticles.add(new Article(2, "Aricle2",
                DateFormat.getDateTimeInstance().format(new Date()),"mobiles in the market now are goood"));

        newArticles.add(new Article(3, "Article3",
                DateFormat.getDateTimeInstance().format(new Date()),"mobiles in the market now are goood"));

      return newArticles;


    }
}
