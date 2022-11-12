package com.esprit.bluegymproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
                Float t = Float.parseFloat(Taille.getText().toString());
                Float p = Float.parseFloat(poids.getText().toString());
                float S =p/(t*t);
                final TextView mTextView = (TextView) findViewById(R.id.valeur);
                if(S<18.5)
                {
                    mTextView.setText(String.valueOf(S)+" Maigreur");
                }
                else
                {
                    if( S>18.5 && S<30)
                    {
                        mTextView.setText(String.valueOf(S)+" Idéal");

                    }
                    else
                    {
                        mTextView.setText(String.valueOf(S)+" You are FaT");
                    }
                }

                System.out.println("dcdcd"+S);





            }
        });
   }
}