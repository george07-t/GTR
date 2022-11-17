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

    //TABLE 2
    private static final String Tablename1="Login_Logout_details";
    private static final String Id="_ID";
    private static final String NAME="Name";
    private static final String EMAIL="Email";
    private static final String USERNAME="UserName";
    private static final String PASS="Password";
    private static final String CREATE_TABLE = "CREATE TABLE " +Tablename1+ "("+Id+" INTEGER PRIMARY KEY AUTOINCREMENT, " +NAME+ "  VARCHAR(255)," +EMAIL+ "  TEXT NOT NULL ," +USERNAME+ "  TEXT NOT NULL," +PASS+ "  TEXT NOT NULL); ";
    private static final String DROP="DROP TABLE IF EXISTS "+Tablename1;
    private static final String Selectlogin="SELECT * FROM "+Tablename1;
    //END OF TABLE 2

    public MYDatabaseHelper(@Nullable Context context) {
        super(context,database,null,version);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
       try
       {
           Toast.makeText(context, "onCreated is created 2", Toast.LENGTH_LONG).show();
           sqLiteDatabase.execSQL(create_table);
           sqLiteDatabase.execSQL(CREATE_TABLE);
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
            sqLiteDatabase.execSQL(DROP);
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

    //table2
    public long insertdata1(String name,String email,String username,String pass)
    {
        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(NAME,name);
        contentValues.put(EMAIL,email);
        contentValues.put(USERNAME,username);
        contentValues.put(PASS,pass);
        long rowid1 = sqLiteDatabase.insert(Tablename1,null,contentValues);
        return rowid1;

    }
    public Boolean findpassword(String user,String pass)
    {
        SQLiteDatabase sqLiteDatabase= this.getReadableDatabase();
        Cursor cursor= sqLiteDatabase.rawQuery(Selectlogin,null);
        Boolean result =false;
        if(cursor.getCount()==0)
        {
            Toast.makeText(context, "No Data Found", Toast.LENGTH_SHORT).show();
        }
        else
        {
        while (cursor.moveToNext())
        {
            String username=cursor.getString(3);
            String password=cursor.getString(4);
            if(username.equals(user)&&password.equals(pass))
            {result=true;
            break;}
        }

        }
        return  result;

    }
    //end
    public Cursor displaydata()
    {
        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
       Cursor cursor= sqLiteDatabase.rawQuery(selectall,null);

        return cursor;
    }
    public boolean updatedata(String id,String name,String age,String gender)
    {
        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(ID,Integer.parseInt(id));
        contentValues.put(Name,name);
        contentValues.put(Age,Integer.parseInt(age));
        contentValues.put(Gender,gender);
        sqLiteDatabase.update(tablename,contentValues,ID+" = ?",new String[]{id});
        return  true;
    }
    public int deletedata(String id)
    {
        SQLiteDatabase sqLiteDatabase= this.getWritableDatabase();
       return sqLiteDatabase.delete(tablename,ID+" = ?",new String[]{id});
    }

}
