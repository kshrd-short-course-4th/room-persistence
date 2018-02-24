package com.example.rathana.roomdatabasedemo.data.local.room.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.rathana.roomdatabasedemo.entity.User;

import java.util.List;

/**
 * Created by RATHANA on 2/24/2018.
 */

@Dao
public interface UserDao {

    //insert data to table
   @Insert(onConflict = OnConflictStrategy.REPLACE)
    void add(User ... users);
    @Insert()
    void add(List<User> user);

    //update data
    @Update
    void edit(User ... users);
    @Update
    void edit(List<User>  users);

    //delete
    @Delete
    void remove(List<User> users);
  //delete
  @Delete
  void remove(User ... users);
    //select
    @Query("SELECT * FROM users ORDER BY id DESC")
    List<User> getAll();
    @Query("SELECT * FROM users WHERE id= :id")
    User getOne(int id);
}
