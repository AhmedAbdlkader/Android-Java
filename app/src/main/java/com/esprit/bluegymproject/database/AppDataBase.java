package com.esprit.bluegymproject.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.esprit.bluegymproject.dao.UserDao;
import com.esprit.bluegymproject.entity.User;


@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {

    private static AppDataBase instance;
    public abstract UserDao userDao();

    public static AppDataBase getAppDatabase(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class, "room_test_db")

                    .allowMainThreadQueries()
                    .build();

        }
        return instance;
    }

}
