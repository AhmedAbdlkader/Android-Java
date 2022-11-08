package com.esprit.bluegymproject.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.esprit.bluegymproject.entity.User;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void insertOne(User user);
    @Delete
    void delete(User user);
    @Query("SELECT * FROM users")
    List<User> getAll();
    @Query("SELECT * FROM  users WHERE email=(:email) and password=(:password)")
    User login(String email,String password);

}
