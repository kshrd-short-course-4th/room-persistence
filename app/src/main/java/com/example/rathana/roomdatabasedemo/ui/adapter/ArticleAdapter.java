package com.example.rathana.roomdatabasedemo.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
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
    private static final String TAG = "ArticleAdapter";
    ArticleAdapterCallback callback;
    public ArticleAdapter(List<CategoryArticle> articles, Context context) {
        this.articles = articles;
        this.context = context;
        this.callback= (ArticleAdapterCallback) context;
        //Log.e(TAG, "ArticleAdapter: "+this.articles.size());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.article_item_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CategoryArticle categoryArticle=articles.get(0);
        Article article=categoryArticle.articles.get(position);
        holder.articleThumb.setImageResource(R.drawable.thumbnail);
        holder.title.setText(article.title);
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.articleThumb)
        ImageView articleThumb;
        @BindView(R.id.tvArticleTitle)
        TextView title;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callback.onItemClicked(articles.get(0).articles.get(getAdapterPosition()));
                }
            });


        }
    }

    public interface ArticleAdapterCallback{
        void onItemClicked(Article article);
    }
}
