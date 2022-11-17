package com.esprit.bluegymproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Advicemain extends AppCompatActivity {
Button btn;
Button d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advicemain);
        btn =findViewById(R.id.ajouteradvicebtn);
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(Advicemain.this,AjouterAdvicePage.class));
            }
        });

        d =findViewById(R.id.advicesbtn);
        d.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(Advicemain.this, Lastone.class));
            }
        });


    }


}