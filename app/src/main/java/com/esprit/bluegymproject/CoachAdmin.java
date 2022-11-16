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
import com.esprit.bluegymproject.entity.Coach;

import java.util.List;

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

                CoachDao coachDao = appDataBase.coachDao();

                 Coach coach = new Coach();
                coach.setNom(nom.getText().toString());
                coach.setPrenom(String.valueOf(prenom.getText()));
                coach.setSpeciality(spexc.getText().toString());
                coach.setAge( Integer.parseInt(age.getText().toString()));
                coach.setExperience(Integer.parseInt(experience.getText().toString()));
                coachDao.insertOne(coach);
                ///////////////////////////////
                //System.out.println(prenom.getText().toString());
                // System.out.println(spexc.getText().toString());
               // System.out.println("nomcoach : "+ coach. getNom());

                System.out.println( coach);
                List<Coach> coaches=coachDao.getAll();
                for (int i=0; i<coaches.size();i++) {
                    System.out.println(coaches.get(i));
                }

            }

        });




    }

}