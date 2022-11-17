package com.example.cse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpExample extends AppCompatActivity {
    MYDatabaseHelper myDatabaseHelper1;
    private Button ib1;
    private EditText ied1,ied2,ied3,ied4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_example);
        myDatabaseHelper1=new MYDatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase1= myDatabaseHelper1.getWritableDatabase();
        ib1=(Button) findViewById(R.id.ib2);
        ied1=(EditText) findViewById(R.id.ied1);
        ied2=(EditText) findViewById(R.id.ied2);
        ied3=(EditText) findViewById(R.id.ied3);
        ied4=(EditText) findViewById(R.id.ied4);
        ib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=ied1.getText().toString();
                String email=ied2.getText().toString();
                String username =ied3.getText().toString();
                String password =ied4.getText().toString();
                if(name.equals("")&&email.equals("") && username.equals("")&& password.equals(""))
                {
                    Toast.makeText(SignUpExample.this, "Error on signup", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    long rowid1 =myDatabaseHelper1.insertdata1(name,email,username,password);
                    if(rowid1==-1)
                    {
                        Toast.makeText(getApplicationContext(), "Unsuccessfully signup", Toast.LENGTH_SHORT).show();

                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Successfully Signed up", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(SignUpExample.this,LogIn_LogOut.class);
                        startActivity(intent);
                        finish();
                    }
                }
            }
        });
    }
}