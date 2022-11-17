package com.esprit.bluegymproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.esprit.bluegymproject.dao.ProduitDao;
import com.esprit.bluegymproject.database.AppDataBase;
import com.esprit.bluegymproject.entity.Produits;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class listProduit extends AppCompatActivity {





    List<Produits> produits;
    private ProduitAdapter myAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_produit);



        this.produits = new ArrayList<>();


        initResyclerView();
        loadProduitList();


    }



    private void initResyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new ProduitAdapter( this);
        recyclerView.setAdapter(myAdapter);

    }




    private void loadProduitList(){
        AppDataBase appDataBase = AppDataBase.getAppDatabase(this);
        ProduitDao produitDao = appDataBase.produitDao();
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d("TAG", produitDao.getAll().toString());
                List<Produits> buf = produitDao.getAll();
                //Predicate<User> sprc = person -> person.getSpecialite() == Integer.parseInt(getIntent().getStringExtra("spec"));

                myAdapter.setUserList(buf);

            }
        }).start();
    }
}