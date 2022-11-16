package com.esprit.bluegymproject.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.esprit.bluegymproject.entity.Produits;


import java.util.List;

@Dao
public interface ProduitDao {

    @Insert
    void insertOne(Produits produits);
    @Delete
    void delete(Produits produits);
    @Query("SELECT * FROM prod")
    List<Produits> getAll();

}
