package com.esprit.bluegymproject;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.esprit.bluegymproject.dao.CoachDao;
import com.esprit.bluegymproject.dao.TypeAbnDao;
import com.esprit.bluegymproject.database.AppDataBase;

import java.util.ArrayList;
import java.util.List;

public class Mylistt extends AppCompatActivity {
    ListView ls;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mylistt);

    ls=findViewById(R.id.lst);
   // String[] values = new String[]{
          //  "sfax",
          //  "tounes"
   // };
        AppDataBase appDataBase = AppDataBase.getAppDatabase(getApplicationContext());

        TypeAbnDao typeAbnDao = appDataBase.typeAbnDao();

        List<String> l = new ArrayList<>();

        for (int i =0; i<typeAbnDao.getAll().size(); i++)
        {
            l.add(typeAbnDao.getAll().get(i).getNom());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Mylistt.this , R.layout.itemm,R.id.nameooo,l);
        ls.setAdapter(adapter);
    }
}
