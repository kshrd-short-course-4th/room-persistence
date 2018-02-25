package com.example.rathana.roomdatabasedemo.data.local.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.rathana.roomdatabasedemo.data.local.room.dao.ArticleDao;
import com.example.rathana.roomdatabasedemo.data.local.room.dao.CategoryDao;
import com.example.rathana.roomdatabasedemo.data.local.room.dao.UserDao;
import com.example.rathana.roomdatabasedemo.entity.Article;
import com.example.rathana.roomdatabasedemo.entity.Category;
import com.example.rathana.roomdatabasedemo.entity.User;

/**
 * Created by RATHANA on 2/24/2018.
 */
@Database(version = 1,entities = {User.class, Category.class, Article.class})
public abstract class AppDataBase extends RoomDatabase {
        public abstract UserDao userDao();
        public abstract CategoryDao categoryDao();
        public abstract ArticleDao articleDao();

    public static AppDataBase getInstance(Context context){
        return Room.databaseBuilder(
          context, AppDataBase.class,"article_db")
                .allowMainThreadQueries()
                .build();
    }

}
