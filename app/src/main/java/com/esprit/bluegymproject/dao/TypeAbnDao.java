package com.esprit.bluegymproject.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.esprit.bluegymproject.entity.TypeAbn;

import java.util.List;

@Dao
public interface TypeAbnDao {
    @Insert
    void insertOne(TypeAbn typeAbn);
    @Delete
    void delete(TypeAbn typeAbn);

    @Query("SELECT * FROM typeabn")
    List<TypeAbn> getAll();


}
