package com.example.rathana.roomdatabasedemo.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rathana.roomdatabasedemo.R;
import com.example.rathana.roomdatabasedemo.entity.Article;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArticleDetailActivity extends AppCompatActivity {

    @BindView(R.id.title)
    TextView tvTitle;
    @BindView(R.id.content)
    TextView tvContent;
    @BindView(R.id.articleImage)
    ImageView ivImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_detail);
        ButterKnife.bind(this);

        Article article=null;
        Intent intent=getIntent();
        if(intent!=null){
            article=intent.getParcelableExtra("article");
            ivImage.setImageResource(R.drawable.thumbnail);
            tvTitle.setText(article.title);
            tvContent.setText(article.content);
        }


    }
}
