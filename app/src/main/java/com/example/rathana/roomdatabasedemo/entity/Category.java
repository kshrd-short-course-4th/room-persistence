package com.example.rathana.roomdatabasedemo.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by RATHANA on 2/24/2018.
 */
@Entity(tableName = "Category")
public class Category {
    @PrimaryKey(autoGenerate = true)
    public int id ;
    public String name;
    public String description;

}

