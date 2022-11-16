package com.esprit.bluegymproject.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.esprit.bluegymproject.dao.CoachDao;
import com.esprit.bluegymproject.dao.ProduitDao;
import com.esprit.bluegymproject.dao.TypeAbnDao;
import com.esprit.bluegymproject.dao.UserDao;
import com.esprit.bluegymproject.entity.Coach;
import com.esprit.bluegymproject.entity.Produits;
import com.esprit.bluegymproject.entity.TypeAbn;
import com.esprit.bluegymproject.entity.User;


@Database(entities = {User.class ,Coach.class , TypeAbn.class, Produits.class}, version = 3, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {

    private static AppDataBase instance;


    public abstract UserDao userDao();
    public abstract ProduitDao produitDao();
    public abstract CoachDao coachDao();
    public abstract TypeAbnDao typeAbnDao();






    public static AppDataBase getAppDatabase(Context  context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class, "room_test_db")

                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();

        }
        return instance;
    }

}
