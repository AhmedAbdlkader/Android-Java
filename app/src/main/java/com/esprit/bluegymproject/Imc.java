package com.esprit.bluegymproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Imc extends AppCompatActivity {
EditText Taille;
    EditText poids;
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);
        btn=findViewById(R.id.icmb);
        Taille=findViewById(R.id.taille);
        poids=findViewById(R.id.poids);
        String sTextFromET = Taille.getText().toString();
        String ss = poids.getText().toString();


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int t = Integer.parseInt(Taille.getText().toString());
                int p = Integer.parseInt(poids.getText().toString());


                System.out.println("dcdcd"+t);





            }
        });
   }
}