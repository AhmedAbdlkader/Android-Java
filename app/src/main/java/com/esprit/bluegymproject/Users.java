package com.esprit.bluegymproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.esprit.bluegymproject.dao.UserDao;
import com.esprit.bluegymproject.database.AppDataBase;
import com.esprit.bluegymproject.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Users extends AppCompatActivity {

    List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        this.users = new ArrayList<>();
        //initResyclerView();
        loadUserList();
    }




    private void loadUserList(){
        AppDataBase appDataBase = AppDataBase.getAppDatabase(this);
        UserDao userDao = appDataBase.userDao();
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d("TAG", userDao.getAll().toString());
                List<User> buf = userDao.getAll();
                //Predicate<User> sprc = person -> person.getSpecialite() == Integer.parseInt(getIntent().getStringExtra("spec"));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    users = buf.stream().collect(Collectors.toList());
                }
                //myAdapter.setUserList(doctors);

            }
        }).start();
    }
}