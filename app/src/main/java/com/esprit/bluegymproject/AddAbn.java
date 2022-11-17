package com.esprit.bluegymproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddAbn extends AppCompatActivity {
Button abnbtn , listabnbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_abn);

        abnbtn =findViewById(R.id.ajouterabnnn);
        abnbtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(AddAbn.this,AjouterAbn.class));
            }
        });

        listabnbtn =findViewById(R.id.listabnnn);
        listabnbtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(AddAbn.this,Mylistt.class));
            }
        });

    }
}