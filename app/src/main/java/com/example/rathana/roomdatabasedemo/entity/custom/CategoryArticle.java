package com.example.rathana.roomdatabasedemo.entity.custom;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import com.example.rathana.roomdatabasedemo.entity.Article;
import com.example.rathana.roomdatabasedemo.entity.User;

import java.util.List;

/**
 * Created by RATHANA on 2/25/2018.
 */

public class CategoryArticle {
    @ColumnInfo(name = "cat_id")
    public int categoryId;
    @ColumnInfo(name = "category_name")
    public String categoryName;
    @ColumnInfo(name = "category_description")
    public String categoryDescription;
    @Embedded
    public User user;

    @Relation(parentColumn = "cat_id",
            entityColumn ="category_id" )
    public List<Article> articles;

    @Override
    public String toString() {
        return "CategoryArticle{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", categoryDescription='" + categoryDescription + '\'' +
                ", user=" + user +
                ", articles=" + articles +
                '}';
    }
}
