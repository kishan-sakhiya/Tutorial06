package com.rku_18fotca11036.tutorial06;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.app.ActionBar.DISPLAY_SHOW_CUSTOM;

public class Login extends AppCompatActivity {

    EditText edtUsername,edtPassword;
    Button btnLogin;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        getSupportActionBar().setDisplayOptions(DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar);

        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtUsername.getText().toString();
                String password = edtPassword.getText().toString();

                if(username.equals(""))
                {
                    Toast.makeText(Login.this, "Please, Fill the username", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(password.equals(""))
                {
                    Toast.makeText(Login.this, "Please, Fill the password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(password.length() < 8)
                {
                    Toast.makeText(Login.this, "Password minimum 8 character", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(username).matches())
                {
                    Toast.makeText(Login.this, "Username must be email address", Toast.LENGTH_SHORT).show();
                }
                if(username.equals("admin@gmail.com") && password.equals("adminadmin"))
                {

                    SharedPreferences preferences = getSharedPreferences("university",MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("username",username);
                    editor.commit();

                    Intent intent = new Intent(Login.this,Welcome.class);
                    startActivity(intent);
                    finish();
                    Toast.makeText(Login.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Login.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void register(View view) {
        startActivity(new Intent(Login.this,Registration.class));

    }
}