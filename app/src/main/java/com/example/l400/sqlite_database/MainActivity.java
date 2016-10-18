package com.example.l400.sqlite_database;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

     EditText name,surname,marks;
    StringBuffer stringBuffer;

    int mark;
    DatabaseHelper databaseHelper;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseHelper = new DatabaseHelper(MainActivity.this);
        name = (EditText)findViewById(R.id.name);
        surname = (EditText)findViewById(R.id.surname);
        marks = (EditText)findViewById(R.id.marks);
        Button  add = (Button)findViewById(R.id.button);
        Button b = (Button)findViewById(R.id.button3);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);

                startActivity(intent);
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mark =  Integer.parseInt(marks.getText().toString());

                boolean inserted = databaseHelper.inserData(name.getText().toString(),surname.getText().toString(),mark);
                if(inserted == true)
                    Toast.makeText(MainActivity.this, "data inserted succesfully", Toast.LENGTH_SHORT).show();

               else
                    Toast.makeText(MainActivity.this, "data not added", Toast.LENGTH_SHORT).show();

            }
        });
        Button show = (Button)findViewById(R.id.button2);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cr = databaseHelper.getdata();
                if (cr.getCount() == 0){
                   showMessages("no data", "found");
                }
                 stringBuffer = new StringBuffer();
                while(cr.moveToNext()){
                    stringBuffer.append("Name is "+ cr.getString(0)+"\n");
                    stringBuffer.append("surname is "+ cr.getString(1)+"\n");
                    stringBuffer.append("marks is "+ cr.getString(2)+"\n\n\n");
                }
                showMessages("Data" , stringBuffer.toString());
            }
        });

    }
    public void showMessages(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }


    }

