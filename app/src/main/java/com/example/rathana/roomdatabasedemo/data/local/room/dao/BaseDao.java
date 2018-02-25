package com.example.rathana.roomdatabasedemo.data.local.room.dao;

import java.util.List;

/**
 * Created by RATHANA on 2/25/2018.
 */

public interface BaseDao<T> {

    void add(T ... t);
    void remove(T ... t);
    void edit(T ... t);

    List<T> getAll();
    T getOne(int id);
}
