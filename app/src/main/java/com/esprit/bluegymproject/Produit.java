package com.esprit.bluegymproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.esprit.bluegymproject.dao.ProduitDao;
import com.esprit.bluegymproject.dao.UserDao;
import com.esprit.bluegymproject.database.AppDataBase;
import com.esprit.bluegymproject.entity.Produits;
import com.esprit.bluegymproject.entity.User;

public class Produit extends AppCompatActivity {

    EditText nom,description,marque,price,image;
    Button ajouter,login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produit);

        nom = findViewById(R.id.nom);
        description = findViewById(R.id.description);
        marque = findViewById(R.id.marque);
        price = findViewById(R.id.price);
        //image = findViewById(R.id.register);
        ajouter = findViewById(R.id.ajouterProduit);

        ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //creating user entity
                Produits produits = new Produits();
                produits.setName(nom.getText().toString());
                produits.setDescription(description.getText().toString());
                produits.setMarque(marque.getText().toString());
                produits.setPrice(price.getText().toString());

                if(validateInput(produits)){
                    // insert operation
                    AppDataBase appDataBase = AppDataBase.getAppDatabase(getApplicationContext());
                    ProduitDao produitDao = appDataBase.produitDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            //register User
                            produitDao.insertOne(produits);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(),"user registred success",Toast.LENGTH_SHORT).show();

                                }
                            });
                        }
                    }).start();

                }else {
                    Toast.makeText(getApplicationContext(),"fill all fields",Toast.LENGTH_SHORT).show();
                }
            }


        });
    }

    private boolean validateInput(Produits produits){
        if (produits.getName().isEmpty() || produits.getPrice().isEmpty() || produits.getDescription().isEmpty() ||produits.getMarque().isEmpty()){
            return false;
        }
        return true;
    }
}