package com.esprit.bluegymproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminDashboard extends AppCompatActivity {
    Button yourButton,co;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

          co = findViewById(R.id.Coachbtn);
        co.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(AdminDashboard.this,CoachAdmin.class));
            }
        });


         yourButton =findViewById(R.id.ajouterProteine);
        yourButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(AdminDashboard.this,Produit.class));
            }
        });


    }
}