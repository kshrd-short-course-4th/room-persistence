package com.example.rathana.roomdatabasedemo.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by RATHANA on 2/24/2018.
 */
@Entity(tableName = "article")
public class Article {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String title;
    public String content;
    @ColumnInfo(name = "category_id")
    public int categoryId;
    @ColumnInfo(name = "author_id")
    public int authorId;
}
