package com.esprit.bluegymproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class Abn extends AppCompatActivity {

    Button Imcbtn , yourButton,proteine,coach,regime,abonnement,home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abn);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        proteine=findViewById(R.id.proteine);
        coach=findViewById(R.id.coach);
        regime=findViewById(R.id.regime);
        abonnement=findViewById(R.id.abonnement);
        home=findViewById(R.id.home);

        home.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(Abn.this,HomeScreen.class).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
            }
        });

        regime.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(Abn.this,Regimes.class).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
            }
        });
        abonnement.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(Abn.this,Abn.class).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }
}