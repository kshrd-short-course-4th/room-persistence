package com.example.rathana.roomdatabasedemo.data.local.room;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;
import android.support.annotation.NonNull;

import com.example.rathana.roomdatabasedemo.data.local.room.dao.ArticleDao;
import com.example.rathana.roomdatabasedemo.data.local.room.dao.CategoryDao;
import com.example.rathana.roomdatabasedemo.data.local.room.dao.UserDao;
import com.example.rathana.roomdatabasedemo.entity.Article;
import com.example.rathana.roomdatabasedemo.entity.Book;
import com.example.rathana.roomdatabasedemo.entity.Category;
import com.example.rathana.roomdatabasedemo.entity.User;

/**
 * Created by RATHANA on 2/24/2018.
 */
@Database(version = 2,entities = {User.class, Category.class, Article.class ,Book.class})
public abstract class AppDataBase extends RoomDatabase {
        public abstract UserDao userDao();
        public abstract CategoryDao categoryDao();
        public abstract ArticleDao articleDao();

        public static AppDataBase getInstance(Context context){
            return Room.databaseBuilder(
              context, AppDataBase.class,"article_db")
                    .allowMainThreadQueries()
                    //.addMigrations(MIGRATION_1_2)
                    .fallbackToDestructiveMigration()
                    .build();
        }


        private static Migration MIGRATION_1_2 =new Migration(1,2) {
            @Override
            public void migrate(@NonNull SupportSQLiteDatabase database) {
                database.beginTransaction();
                database.execSQL("CREATE TABLE book(id INTEGER PRIMARY KEY AUTOINCREMENT, name text,desc text,author_id INTEGER not null default 0);");
                database.endTransaction();
            }
        };
}
