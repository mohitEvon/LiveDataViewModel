package com.evon.sample.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
@TypeConverters(DateConverter.class)
public interface ModelD {

    @Query("select * from Model")
    LiveData<List<Model>> getAllItems();

    @Query("select * from Model where id = :id")
    Model getItembyId(String id);

    @Insert(onConflict = REPLACE)
    void addItem(Model model);

    @Delete
    void deleteItem(Model model);

}
