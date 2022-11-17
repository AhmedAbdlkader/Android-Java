package com.esprit.bluegymproject.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.esprit.bluegymproject.entity.Advice;
import com.esprit.bluegymproject.entity.Coach;

import java.util.List;
@Dao
public interface AdviceDao {
    @Insert
    void insertOne(Advice  advice);
    @Delete
    void delete(Advice advice);

    @Query("SELECT * FROM advice")
    List<Advice> getAll();
}
