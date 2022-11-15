package com.example.cse;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SQLDataBaseExample extends AppCompatActivity {
MYDatabaseHelper myDatabaseHelper;
private Button sdb2,ldb1;
private EditText sed1,sed2,sed3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqldata_base_example);
        myDatabaseHelper=new MYDatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase= myDatabaseHelper.getWritableDatabase();
        sdb2=(Button)findViewById(R.id.sdb2);
        sed1=(EditText)findViewById(R.id.sed1);
        sed2=(EditText)findViewById(R.id.sed2);
        sed3=(EditText)findViewById(R.id.sed3);
        ldb1=(Button)findViewById(R.id.ldb1);
        ldb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Cursor resultset = myDatabaseHelper.displaydata();
                if(resultset.getCount()==0)
                {
                    showdata("ERROR","NO DATA");
                    return;
                }
                StringBuffer stringBuffer=new StringBuffer();
                while (resultset.moveToNext())
                {
                    stringBuffer.append("ID = "+resultset.getString(0)+"\n");
                    stringBuffer.append("NAME = "+resultset.getString(1)+"\n");
                    stringBuffer.append("AGE = "+resultset.getString(2)+"\n");
                    stringBuffer.append("GENDER = "+resultset.getString(3)+"\n\n\n");
                }
                showdata("RESULTSET",stringBuffer.toString());
            }
        });


        sdb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=sed1.getText().toString();
                String age=sed2.getText().toString();
                String gender =sed3.getText().toString();
                long rowid =myDatabaseHelper.insertdata(name,age,gender);
                if(rowid==-1)
                {
                    Toast.makeText(getApplicationContext(), "Row not successfully inserted", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Row "+rowid+" is Successfully inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void showdata(String title,String res)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(res);
        builder.setCancelable(true);
        builder.show();
    }
}