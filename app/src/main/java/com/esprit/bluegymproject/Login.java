package com.esprit.bluegymproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

import com.esprit.bluegymproject.dao.UserDao;
import com.esprit.bluegymproject.database.AppDataBase;
import com.esprit.bluegymproject.entity.User;

public class Login extends AppCompatActivity {

    EditText email,password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.editEmail);
        password = findViewById(R.id.editPassword);
        login = findViewById(R.id.login);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailtext = email.getText().toString();
                String passwordtext = password.getText().toString();
                if(emailtext.isEmpty() ||passwordtext.isEmpty()){
                    Toast.makeText(getApplicationContext(),"fill all fields",Toast.LENGTH_SHORT).show();
                }else{
                    AppDataBase appDataBase = AppDataBase.getAppDatabase(getApplicationContext());
                    UserDao userDao = appDataBase.userDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            User user = userDao.login(emailtext,passwordtext);
                            Log.d("#########", user.toString());
                            if(user == null ){
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(),"invalid Credentiel",Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }else if(user != null && user.getRole().equals("ADMIN")){

                                Log.d("roleadmin", user.getRole());

                                    String name = user.getFirstName();
                                    startActivity(new Intent(Login.this,AdminDashboard.class)
                                            .putExtra("name",name));

                            }else if(user != null && user.getRole().equals("USER")){

                                Log.d("roleuser", user.getRole());
                                String name = user.getFirstName();
                                startActivity(new Intent(Login.this,HomeScreen.class)
                                        .putExtra("name",name));

                            }

                        }
                    }).start();
                }
            }
        });

    }
}