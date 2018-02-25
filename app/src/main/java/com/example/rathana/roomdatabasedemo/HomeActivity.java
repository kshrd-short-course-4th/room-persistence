package com.example.rathana.roomdatabasedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.rathana.roomdatabasedemo.data.local.room.AppDataBase;
import com.example.rathana.roomdatabasedemo.entity.Article;
import com.example.rathana.roomdatabasedemo.entity.Category;
import com.example.rathana.roomdatabasedemo.entity.custom.CategoryArticle;
import com.example.rathana.roomdatabasedemo.ui.FromCategoryActivity;
import com.example.rathana.roomdatabasedemo.ui.adapter.ArticleAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {
    @BindView(R.id.rvArticle)
    RecyclerView recyclerView;
    ArticleAdapter articleAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        //call method to add articles to table
        //addArticle();
        //getArticles();
        //getOnlyArticle();
        //setup recyclerView
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        articleAdapter=new ArticleAdapter(getArticles(),this);
    }

    private void getOnlyArticle() {
        List<Article> articles= AppDataBase.getInstance(this).articleDao().getAll();
        /*for(Article article: articles){
            Log.e(TAG, "getArticles: "+article.toString() );
        }*/
        showMessage("test");
    }

    private static final String TAG = "HomeActivity";
    private List<CategoryArticle> getArticles() {
        List<CategoryArticle> articles= AppDataBase.getInstance(this).articleDao().getCategoryArticle();
        /*for(CategoryArticle article: articles){
            Log.e(TAG, "getArticles: "+article.toString() );
        }*/
        showMessage("test");
        return articles;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.catId:{
                startActivity(new Intent(this, FromCategoryActivity.class));
                return true;
            }
        }
        return false;
    }

    private void addArticle(){
        List<Article> articles=new ArrayList<>();
        for(int i=0;i<20;i++){
            Article art=new Article();
            art.authorId=2;
            art.categoryId=1;
            art.title="១\u200Bគ្រាប់\u200Bរបស់\u200B Salah យប់\u200Bមិញ\u200Bជាប់\u200Bកំណត់ត្រា\u200Bសំខាន់\u200Bមួយ\u200Bនៅ\u200B Premier League " +i;
            art.content="ជំនួប\u200Bកាល\u200Bពី\u200Bយប់\u200Bមិញ\u200Bម្ចាស់\u200Bផ្ទះ\u200Bរក\u200Bឃើញ\u200Bគ្រាប់\u200Bដំបូង\u200Bនៅ\u200B\u200Bនាទី២៨\u200B ជា\u200Bការ\u200Bតែត\u200Bបញ្ចូល\u200Bទី\u200Bរបស់\u200B Emre Can។ ក្រោយ\u200Bត្រូវ\u200Bគូ\u200Bប្រជែង\u200Bនាំ\u200Bមុខ\u200B West Ham បង្កើត\u200Bឱកាស\u200Bវាយ\u200Bលុក\u200Bវិញ\u200Bច្រើន\u200Bលើក\u200Bដែរ\u200Bពិសេស\u200Bការ\u200Bស៊ុត\u200Bពី\u200Bខ្សែ\u200Bប្រយុទ្ធ\u200Bឆ្នើម\u200B Arnautovic តែ\u200Bមិន\u200Bបាន\u200Bសម្រេច។ \u200B";
            articles.add(art);
        }

        //add to table article
        AppDataBase.getInstance(this).articleDao().add(articles);
        showMessage("save articles success");
    }
    public void showMessage(String message){
        Toast.makeText(this, ""+message, Toast.LENGTH_SHORT).show();
    }

}
