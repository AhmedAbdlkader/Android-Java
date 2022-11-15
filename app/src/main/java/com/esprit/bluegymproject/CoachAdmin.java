package com.esprit.bluegymproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.esprit.bluegymproject.dao.CoachDao;
import com.esprit.bluegymproject.dao.UserDao;
import com.esprit.bluegymproject.database.AppDataBase;

public class CoachAdmin extends AppCompatActivity {
    EditText nom,prenom,age,experience,spexc;
    Button mybtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coach_admin);

        nom =findViewById(R.id.nomc);
        prenom=findViewById(R.id.prenomc);
        age=findViewById(R.id.agec);
        experience=findViewById(R.id.experiencec);
        spexc=findViewById(R.id.spec);
        mybtn=findViewById(R.id.AjouterCoach);


        mybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AppDataBase appDataBase = AppDataBase.getAppDatabase(getApplicationContext());
               // UserDao userDao = appDataBase.userDao();

            }
        });




    }

}