package com.example.yogeshpatil.databasedemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.yogeshpatil.databasedemo", Context.MODE_PRIVATE);

        sharedPreferences.edit().putString("username", "Yogesh").apply();
        sharedPreferences.edit().putString("password", "Patil").apply();

        String Username = sharedPreferences.getString("username", "");
        String Password = sharedPreferences.getString("password", "");

        Log.i("Username", Username);
        Log.i("Password", Password);

    }
}
