package com.example.cse;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SQLiteDataList extends AppCompatActivity {
    private ListView dl1;
     MYDatabaseHelper myDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_data_list);
        dl1=(ListView) findViewById(R.id.dl1);
        myDatabaseHelper=new MYDatabaseHelper(this);
        //SQLiteDatabase sqLiteDatabase= myDatabaseHelper.getWritableDatabase();
        listloaddata();
    }
    public void listloaddata(){
        ArrayList<String> listdata=new ArrayList<>();
        Cursor cursor=myDatabaseHelper.displaydata();
        if(cursor.getCount()==0)
        {
            Toast.makeText(getApplicationContext(), "No Data", Toast.LENGTH_SHORT).show();
        }
        else
        {
            while (cursor.moveToNext())
            {
                listdata.add(cursor.getString(0)+"\t"+cursor.getString(1));
            }
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<String >(this,R.layout.list_sample,R.id.txt2,listdata);
        dl1.setAdapter(adapter);
        dl1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String value=adapterView.getItemAtPosition(i).toString();
                Toast.makeText(SQLiteDataList.this, "You select "+value, Toast.LENGTH_SHORT).show();
            }
        });
    }
}