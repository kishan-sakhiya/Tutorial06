package com.rku_18fotca11036.tutorial06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.view.View;

public class Welcome extends AppCompatActivity {

    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        preferences = getSharedPreferences("university",MODE_PRIVATE);
        String userPreference = preferences.getString("username","");

        if(userPreference.equals(""))
        {
            Intent intent = new Intent(Welcome.this,Login.class);
            startActivity(intent);
            finish();
        }
    }

    public void logout(View view) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
//        editor.putString("username","");
        editor.commit();

        Intent intent = new Intent(Welcome.this,Login.class);
        startActivity(intent);
        finish();
    }
}