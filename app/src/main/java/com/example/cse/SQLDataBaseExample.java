package com.example.cse;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SQLDataBaseExample extends AppCompatActivity {
MYDatabaseHelper myDatabaseHelper;
private Button sdb2,ldb1,udb1,ddb1;
private EditText sed1,sed2,sed3,sed4;
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
        sed4=(EditText)findViewById(R.id.sed4);
        ldb1=(Button)findViewById(R.id.ldb1);
        ddb1=(Button)findViewById(R.id.ddb1);
        udb1=(Button)findViewById(R.id.udb1);
        ddb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String idvalue =sed4.getText().toString();
               if(idvalue!="")
               {
                int value= myDatabaseHelper.deletedata(idvalue);
                if(value>0)
                {
                    Toast.makeText(getApplicationContext(), "Row  is Successfully Deleted", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Row not successfully Deleted", Toast.LENGTH_SHORT).show();
                }
               }
               else
               {
                   Toast.makeText(SQLDataBaseExample.this, "Error on Deleting", Toast.LENGTH_SHORT).show();
               }
            }
        });
        udb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=sed1.getText().toString();
                String age=sed2.getText().toString();
                String gender =sed3.getText().toString();
                String idvalue =sed4.getText().toString();
                if(name.equals("")||age.equals("") || gender.equals("")||idvalue.equals(""))
                {
                    Toast.makeText(SQLDataBaseExample.this, "Error on Updating", Toast.LENGTH_SHORT).show();
                }
                else
                {
              boolean isupdated=  myDatabaseHelper.updatedata(idvalue,name,age,gender);
                if(isupdated==true)
                {
                    Toast.makeText(getApplicationContext(), "Row  is Successfully Updated", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Row not successfully Updated", Toast.LENGTH_SHORT).show();
                }
                }


            }
        });
/*        ldb1.setOnClickListener(new View.OnClickListener() {
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
        });*/
        ldb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SQLDataBaseExample.this,SQLiteDataList.class);
                startActivity(intent);
            }
        });


        sdb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=sed1.getText().toString();
                String age=sed2.getText().toString();
                String gender =sed3.getText().toString();
                if(name.equals("")||age.equals("") || gender.equals(""))
                {
                    Toast.makeText(SQLDataBaseExample.this, "Error on Inserting", Toast.LENGTH_SHORT).show();
                }
                else
                {
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