package com.example.rathana.roomdatabasedemo.data.local.room.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.rathana.roomdatabasedemo.entity.Category;

import java.util.List;

/**
 * Created by RATHANA on 2/25/2018.
 */

@Dao
public interface CategoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void add(Category ... categories);
    @Update
    void edit(Category ... categories);
    @Delete
    void remove (Category ... categories);

    //select
    @Query("SELECT * FROM category ORDER BY id DESC")
    List<Category> getAll();

    @Query("SELECT * FROM category WHERE id= :id")
    Category getOne(int id);

}
