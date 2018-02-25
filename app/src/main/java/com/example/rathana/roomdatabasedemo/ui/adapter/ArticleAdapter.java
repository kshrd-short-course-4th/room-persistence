package com.example.rathana.roomdatabasedemo.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rathana.roomdatabasedemo.R;
import com.example.rathana.roomdatabasedemo.entity.Article;
import com.example.rathana.roomdatabasedemo.entity.custom.CategoryArticle;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by RATHANA on 2/25/2018.
 */

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder>{
    private List<CategoryArticle> articles;
    private Context context;

    public ArticleAdapter(List<CategoryArticle> articles, Context context) {
        this.articles = articles;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.articla_item_layout,parent,false);
        return new ViewHolder(view);
    }

    private static final String TAG = "ArticleAdapter";
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CategoryArticle a=articles.get(0);
        Log.e(TAG, "onBindViewHolder: "+articles.size() );
        //Log.e(TAG, "onBindViewHolder: "+articles.get(0).toString() );
        Article article=a.articles.get(position);
        holder.articleThumb.setImageResource(R.drawable.thumbnail);
        //Log.e(TAG, "onBindViewHolder: "+article.title );
        holder.title.setText(article.title);
    }
    @Override
    public int getItemCount() {
        return articles.size();
    }
    static  class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.articleThumb)
        ImageView articleThumb;
        @BindView(R.id.tvArticleTitle)
        TextView title;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
