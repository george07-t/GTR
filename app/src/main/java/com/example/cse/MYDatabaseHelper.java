package com.example.cse;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MYDatabaseHelper extends SQLiteOpenHelper {
    private static final String database="Student.db";
    private static final String tablename="Student_details";
    private static final String ID="_ID";
    private static final String Name="Student_Name";
    private static final String Age="Student_age";
    private static final String Gender="SGender";
    private static final int version=2;
    private final  Context context;
    private static final String create_table = "CREATE TABLE " +tablename+ "("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, " +Name+ "  VARCHAR(255)," +Age+ " INTEGER ," +Gender+ " VARCHAR(15)); ";
    private static final String drpo="DROP TABLE IF EXISTS "+tablename;
    private static final String selectall="SELECT * FROM "+tablename;
    public MYDatabaseHelper(@Nullable Context context) {
        super(context,database,null,version);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
       try
       {
           Toast.makeText(context, "onCreated is created", Toast.LENGTH_LONG).show();
           sqLiteDatabase.execSQL(create_table);
       }
       catch (Exception e)
       {
           Toast.makeText(context, "Exception "+e, Toast.LENGTH_LONG).show();
       }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        try {
            Toast.makeText(context, "onUpgrade is created", Toast.LENGTH_LONG).show();
            sqLiteDatabase.execSQL(drpo);
            onCreate(sqLiteDatabase);
        }catch (Exception e)
        {
            Toast.makeText(context, "Exception occurs "+e, Toast.LENGTH_LONG).show();
        }


    }
    public long insertdata(String name,String age,String gender)
    {
     SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Name,name);
        contentValues.put(Age,Integer.parseInt(age));
        contentValues.put(Gender,gender);
        long rowid = sqLiteDatabase.insert(tablename,null,contentValues);
        return rowid;

    }
    public Cursor displaydata()
    {
        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
       Cursor cursor= sqLiteDatabase.rawQuery(selectall,null);

        return cursor;
    }

}
