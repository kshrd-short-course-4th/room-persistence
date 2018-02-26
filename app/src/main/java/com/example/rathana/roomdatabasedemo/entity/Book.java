package com.example.rathana.roomdatabasedemo.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by ratha on 2/26/2018.
 */

@Entity(tableName = "book")
public class Book {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name;
    public String desc;
    @ColumnInfo(name = "author_id")
    public int authorId;
}
