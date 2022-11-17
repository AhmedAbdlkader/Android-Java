package com.esprit.bluegymproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.esprit.bluegymproject.dao.AdviceDao;
import com.esprit.bluegymproject.dao.CoachDao;
import com.esprit.bluegymproject.database.AppDataBase;
import com.esprit.bluegymproject.entity.Advice;
import com.esprit.bluegymproject.entity.Coach;

import java.util.List;

public class AjouterAdvicePage extends AppCompatActivity {
    EditText msg ;
    Button mybtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_advice_page);

        msg =findViewById(R.id.messagetxt);
        mybtn=findViewById(R.id.finalbtn);

        mybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AppDataBase appDataBase = AppDataBase.getAppDatabase(getApplicationContext());

                AdviceDao adviceDao = appDataBase.AdviceDao();

                Advice advice = new Advice() ;
                advice.setMessage(msg.getText().toString());

                adviceDao.insertOne(advice);
                ///////////////////////////////
                //System.out.println(prenom.getText().toString());
                // System.out.println(spexc.getText().toString());
                // System.out.println("nomcoach : "+ coach. getNom());

                System.out.println( advice);
                List<Advice> advicess =adviceDao.getAll();
                for (int i=0; i<advicess.size();i++) {
                    System.out.println(advicess.get(i));
                }

            }

        });





    }
}