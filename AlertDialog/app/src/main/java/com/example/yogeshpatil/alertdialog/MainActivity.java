package com.example.yogeshpatil.alertdialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.yogeshpatil.alertdialog", Context.MODE_PRIVATE);

      //  sharedPreferences.edit().putString("username", "Database").apply();


        String username = sharedPreferences.getString("username","");


        Log.i("username", username);

        new AlertDialog.Builder(this)
                .setIcon(R.drawable.ic_launcher)
                .setTitle("Are you sure???")
                .setMessage("Do you definitely want to do this!!!")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Log.i("Button Tapped", "Yes");
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }
}
