package com.example.yogeshpatil.databasecreated;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            SQLiteDatabase myDatabase = this.openOrCreateDatabase("Users", MODE_PRIVATE, null);

            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR, age INTEGER(3))");

            myDatabase.execSQL("INSERT INTO users (name,age) VALUES ('Yogesh', 24)");
            myDatabase.execSQL("INSERT INTO users (name,age) VALUES ('Abhijit', 25)");
            myDatabase.execSQL("INSERT INTO users (name,age) VALUES ('Dipak', 26)");
            myDatabase.execSQL("INSERT INTO users (name,age) VALUES ('Jayesh', 27)");

            Cursor c = myDatabase.rawQuery("Select * from users " , null);

            int nameIndex = c.getColumnIndex("name");
            int ageIndex = c.getColumnIndex("age");


            c.moveToFirst();
            while (c != null) {

                Log.i("UserResult", c.getString(nameIndex));
                Log.i("UserResult", Integer.toString(c.getInt(ageIndex)));
                c.moveToNext();
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
