package com.gebeya.habeshanews;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gebeya-admin on 4/8/17.
 */

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {

    ArrayList<Article> articles;
    ItemClickListner itemClickListner;
    int currentPosition;
    private Context context;

    public  interface  ItemClickListner{

        void onItemClick(int adapterPosition);
    }



    public ArticleAdapter(ArrayList<Article> articles,
                          ItemClickListner itemClickListner) {
        this.articles = articles;
        this.itemClickListner = itemClickListner;
        currentPosition  = 0;
    }

    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context =  parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_article_items, parent, false);
        ArticleViewHolder holder = new ArticleViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ArticleViewHolder holder, int position) {
             holder.bind(position);
    }

    @Override
    public int getItemCount() {

        return articles.size();
    }


    public class ArticleViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        int viewposition;
        Article myArticle;
        TextView titleText;
        TextView dateText;
        private ItemClickListner itemClickListner;

        ArticleViewHolder(View itemView) {
            super(itemView);

            titleText = (TextView) itemView.findViewById(R.id.title_text);
            dateText = (TextView) itemView.findViewById(R.id.price_text);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent startDetailActivity  = new Intent(context, DetaileActivity.class);
            Article article = articles.get(getAdapterPosition());
            startDetailActivity.putExtra("Article", article);
            context.startActivity(startDetailActivity);
        }

        public void bind(int  position){
            viewposition  = position;
            myArticle  = articles.get(position);
            titleText.setText(myArticle.getTitle());
            dateText.setText(myArticle.getDate());

        }
    }


}