package com.esprit.bluegymproject.dao;




import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.esprit.bluegymproject.entity.Coach;

import java.util.List;

@Dao
public interface CoachDao {
    @Insert
    void insertOne(Coach coach);
    @Delete
    void delete(Coach coach);


    @Query("SELECT * FROM coachs")
    List<Coach> getAll();


  /*  @Query("SELECT * FROM  users WHERE email=(:email) and password=(:password)")
    User login(String email,String password);*/



}