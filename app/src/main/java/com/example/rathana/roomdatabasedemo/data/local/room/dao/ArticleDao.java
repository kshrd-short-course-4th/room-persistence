package com.example.rathana.roomdatabasedemo.data.local.room.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.rathana.roomdatabasedemo.entity.Article;
import com.example.rathana.roomdatabasedemo.entity.Category;
import com.example.rathana.roomdatabasedemo.entity.custom.CategoryArticle;

import java.util.List;

/**
 * Created by RATHANA on 2/25/2018.
 */

@Dao
public interface  ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void add(Article... articles);
    @Insert
    void add(List<Article> articles);
    @Update
    void edit(Article... articles);
    @Delete
    void remove (Article... articles);

    //select
    @Query("SELECT * FROM article ORDER BY id DESC")
    List<Article> getAll();

    @Query("SELECT * FROM article WHERE id= :id")
    Article getOne(int id );

    //complex query
    @Query("select art.* , u.* , cat.id as cat_id " +
            ",cat.name as category_name , cat.description as category_description from " +
            "article art inner join " +
            "users u on u.id =art.author_id " +
            "inner join category cat on cat.id=art.category_id")
    List<CategoryArticle> getCategoryArticle();

}
