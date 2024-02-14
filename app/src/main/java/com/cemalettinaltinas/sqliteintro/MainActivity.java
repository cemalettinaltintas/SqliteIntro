package com.cemalettinaltinas.sqliteintro;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            SQLiteDatabase database=this.openOrCreateDatabase("School",MODE_PRIVATE,null);
            database.execSQL("CREATE TABLE IF NOT EXISTS Students(id INTEGER PRIMARY KEY ,name VARCHAR,age INT)");
            //database.execSQL("INSERT INTO Students(name,age) VALUES('Serra',17)");
            //database.execSQL("INSERT INTO Students(name,age) VALUES('Tuğba',18)");

            Cursor cursor=database.rawQuery("SELECT * FROM Students WHERE age=17",null);

            int idIx=cursor.getColumnIndex("id");
            int nameIx=cursor.getColumnIndex("name");
            int ageIx=cursor.getColumnIndex("age");

            while (cursor.moveToNext()){
                System.out.println("Id:"+cursor.getString(idIx));
                System.out.println("Name:"+cursor.getString(nameIx));
                System.out.println("Age:"+cursor.getString(ageIx));
                System.out.println("-----------------------------");
            }
            cursor.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}