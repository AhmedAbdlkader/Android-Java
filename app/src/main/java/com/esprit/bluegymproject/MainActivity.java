package com.esprit.bluegymproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.esprit.bluegymproject.dao.UserDao;
import com.esprit.bluegymproject.database.AppDataBase;
import com.esprit.bluegymproject.entity.User;

public class MainActivity extends AppCompatActivity {

    EditText firstname,lastname,pwd,email,role;
    Button register,login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstname = findViewById(R.id.editFirstName);
        lastname = findViewById(R.id.editLastName);
        pwd = findViewById(R.id.editPassword);
        email = findViewById(R.id.editEmail);
        register = findViewById(R.id.register);
        login = findViewById(R.id.login);



        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //creating user entity
                User user = new User();
                user.setFirstName(firstname.getText().toString());
                user.setLastName(lastname.getText().toString());
                user.setPassword(pwd.getText().toString());
                user.setEmail(email.getText().toString());
                user.setRole("USER");
                if(validateInput(user)){
                    // insert operation
                    AppDataBase appDataBase = AppDataBase.getAppDatabase(getApplicationContext());
                    UserDao userDao = appDataBase.userDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            //register User
                            userDao.insertOne(user);
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

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Login.class));
            }
        });

    }

    private boolean validateInput(User user){
        if (user.getFirstName().isEmpty() || user.getLastName().isEmpty() || user.getPassword().isEmpty() ||user.getEmail().isEmpty()){
            return false;
        }
        return true;
    }
}