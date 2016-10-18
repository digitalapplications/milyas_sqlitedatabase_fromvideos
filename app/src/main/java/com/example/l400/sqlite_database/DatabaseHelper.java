package com.example.l400.sqlite_database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by l400 on 10/1/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String Database_Name = "student.db";
    public static  final String Table_Name = "student_info";
   // public static final String col_1 = "ID";
  //  public static final String col_2 = "NAME";
    //public static final String col_3 = "SURNAME";
    //public static final String col_4 = "MARKS";

    public DatabaseHelper(Context context) {
        super(context, Database_Name, null, 1);
      //  SQLiteDatabase database = this.getWritableDatabase();
    }
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
    sqLiteDatabase.execSQL("CREATE TABLE " +Table_Name+ "(NAME TEXT,SURNAME TEXT,MARKS INTEGER);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    sqLiteDatabase.execSQL("DROP TABLE IF EXIST" +Table_Name);
        onCreate(sqLiteDatabase);

    }
    public boolean inserData(String name ,String surmane ,int marks)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME",name);
        contentValues.put("SURNAME",surmane);
        contentValues.put("MARKS",marks);
       long result=  db.insert(Table_Name,null,contentValues);
        if(result == -1){
            return false;
        }
        else {
            return true;
        }
    }
    public Cursor getdata(){
        SQLiteDatabase db = this.getWritableDatabase();
        String name = "SELECT * FROM " + Table_Name;
           Cursor cursor = db.rawQuery(name,null);
        return cursor;
    }
    public List<String> getname() {
        SQLiteDatabase db = this.getWritableDatabase();
        String name = "SELECT * FROM " + Table_Name;
        List<String> nam = new ArrayList<>();
        Cursor cursor = db.rawQuery(name, null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            do {
                String n = cursor.getString(cursor.getColumnIndex("NAME"));
                nam.add(n);
            } while (cursor.moveToNext());

        }
        return nam;
    }
    public List<String> getsurname() {
        SQLiteDatabase db = this.getWritableDatabase();
        String name = "SELECT * FROM " + Table_Name;
        List<String> surname = new ArrayList<>();
        Cursor cursor = db.rawQuery(name, null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            do {
                String n = cursor.getString(cursor.getColumnIndex("SURNAME"));
                surname.add(n);
            } while (cursor.moveToNext());

        }
        return surname;
    }
}
