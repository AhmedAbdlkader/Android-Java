package com.esprit.bluegymproject;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.esprit.bluegymproject.dao.AdviceDao;
import com.esprit.bluegymproject.database.AppDataBase;

import java.util.ArrayList;
import java.util.List;

public class Lastone extends AppCompatActivity {
    ListView ls;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lastone);

        ls=findViewById(R.id.lstt);
        // String[] values = new String[]{
        //  "sfax",
        //  "tounes"
        // };
        AppDataBase appDataBase = AppDataBase.getAppDatabase(getApplicationContext());

        AdviceDao adviceDao = appDataBase.AdviceDao();

        List<String> l = new ArrayList<>();

        for (int i =0; i<adviceDao.getAll().size(); i++)
        {
            l.add(adviceDao.getAll().get(i).getMessage());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Lastone.this , R.layout.itemmm,R.id.finalmsg,l);
        ls.setAdapter(adapter);
    }
}

