package com.esprit.bluegymproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.esprit.bluegymproject.dao.CoachDao;
import com.esprit.bluegymproject.dao.TypeAbnDao;
import com.esprit.bluegymproject.database.AppDataBase;
import com.esprit.bluegymproject.entity.Coach;
import com.esprit.bluegymproject.entity.TypeAbn;

import java.util.List;

public class AjouterAbn extends AppCompatActivity {
    EditText nom,age,description,prix;
    Button mybtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_abn);

        nom=findViewById(R.id.nomabn);
        age=findViewById(R.id.Ageminabn);
        description=findViewById(R.id.Descriptionabn);
        prix=findViewById(R.id.prixabn);
        mybtn=findViewById(R.id.AjouterAbonnement);




        mybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AppDataBase appDataBase = AppDataBase.getAppDatabase(getApplicationContext());
                TypeAbnDao typeAbnDao = appDataBase.typeAbnDao();


                TypeAbn abn = new TypeAbn();
                abn.setNom(nom.getText().toString());
                abn.setDescription(description.getText().toString());
                 abn.setAge( Integer.parseInt(age.getText().toString()));
                abn.setPrice(Integer.parseInt(prix.getText().toString()));
                typeAbnDao.insertOne(abn);
                ///////////////////////////////
                //System.out.println(prenom.getText().toString());
                // System.out.println(spexc.getText().toString());
                // System.out.println("nomcoach : "+ coach. getNom());

                 List<TypeAbn> typeAbns=typeAbnDao.getAll();
                for (int i=0; i<typeAbns.size();i++) {
                    System.out.println(typeAbns.get(i));
                }

            }

        });



    }
}