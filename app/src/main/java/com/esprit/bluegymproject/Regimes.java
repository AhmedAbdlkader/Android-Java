package com.esprit.bluegymproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Regimes extends AppCompatActivity {

    Button Imcbtn , yourButton,proteine,coach,regime,abonnement,home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regimes);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Imcbtn =findViewById(R.id.IMC);


        proteine=findViewById(R.id.proteine);
        coach=findViewById(R.id.coach);
        regime=findViewById(R.id.regime);
        abonnement=findViewById(R.id.abonnement);
        home=findViewById(R.id.home);

        yourButton =findViewById(R.id.fat);
        yourButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(Regimes.this,Fatlose.class));
            }
        });

        Imcbtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(Regimes.this,Imc.class));
            }
        });



        regime.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(Regimes.this,Regimes.class).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
            }
        });
        abonnement.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(Regimes.this,Abn.class).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
            }
        });

        home.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(Regimes.this,HomeScreen.class).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
            }
        });
        proteine.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(Regimes.this,listProduit.class).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.dd:
                startActivity(new Intent( this, Abn.class));
                break;
            case R.id.regime:
                startActivity(new Intent( this, Regimes.class));
                break;
        }
        return true;
    }


}