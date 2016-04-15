package com.example.ira.healthhelper;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userList = new ArrayList();
        userList.add(new User("ira123", "12345678"));
        userList.add(new User("a", "a"));

        final Button signInButton = (Button) findViewById(R.id.sign_in_button);
        final Button signUpButton = (Button) findViewById(R.id.sign_up_button);
        if (signInButton != null) {
            signInButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    EditText login = (EditText) findViewById(R.id.login);
                    EditText password = (EditText) findViewById(R.id.parol);
                    String loginOfUser = login.getText().toString();
                    String passwordOfUser = password.getText().toString();
                    User currentUser = null;

                    for (User user : userList) {
                        if (user.getLogin().equals(loginOfUser)) {
                            currentUser = user;
                            break;
                        }
                    }

                    if (currentUser != null && currentUser.getPassword().
                            equals(passwordOfUser)) {
                        Intent intent = new Intent(MainActivity.this, SystemActivity.class);
                        startActivity(intent);
                        //  finish();
                    } else {
                        Toast.makeText(MainActivity.this, "Введіть правильний логін", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
        signUpButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }


}