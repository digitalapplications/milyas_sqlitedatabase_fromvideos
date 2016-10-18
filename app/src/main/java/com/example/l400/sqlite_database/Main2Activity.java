package com.example.l400.sqlite_database;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    DatabaseHelper databaseHelper;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        databaseHelper = new DatabaseHelper(Main2Activity.this);
        ListView listView = (ListView)findViewById(R.id.listView);
        List<String> list = new ArrayList<>();
       List<String> l = databaseHelper.getname();
        //List<Cursor> list1 = (List<Cursor>) databaseHelper.getdata();
        ArrayAdapter arrayAdapter = new ArrayAdapter(Main2Activity.this,android.R.layout.simple_list_item_1,l);
        listView.setAdapter(arrayAdapter);

    }
}
