package com.example.cse;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogIn_LogOut extends AppCompatActivity {
    MYDatabaseHelper myDatabaseHelper1;
    private Button lb1,lb2;
    private EditText led1,led2;
    private sessionmanager session;
    private AlertDialog.Builder alart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_log_out);
        myDatabaseHelper1=new MYDatabaseHelper(this);
        SQLiteDatabase sqLiteDatabase1= myDatabaseHelper1.getWritableDatabase();
        lb1=(Button) findViewById(R.id.lb1);
        lb2=(Button) findViewById(R.id.lb2);
        led1=(EditText) findViewById(R.id.led1);
        led2=(EditText) findViewById(R.id.led2);
        session=new sessionmanager(getApplicationContext());
        if(session.isLoogedIn()){
            Intent intent=new Intent(LogIn_LogOut.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
        session=new sessionmanager(getApplicationContext());
        lb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LogIn_LogOut.this,SignUpExample.class);
                startActivity(intent);
            }
        });
        lb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username =led1.getText().toString();
                String password =led2.getText().toString();
                if(username.equals("")|| password.equals(""))
                {
                    errormessage();
                }
                else {
                    Boolean result = myDatabaseHelper1.findpassword(username, password);
                    if (result == true) {
                        Intent intent = new Intent(LogIn_LogOut.this, MainActivity.class);
                        startActivity(intent);
                        Toast.makeText(LogIn_LogOut.this, "Successfully Log in to " + username, Toast.LENGTH_SHORT).show();
                        session.setLogin(true);
                        finish();
                    } else {

                        Toast.makeText(LogIn_LogOut.this, "Username or Passsword didn't Correct", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    @Override
    public void onBackPressed() {

        alart = new AlertDialog.Builder(LogIn_LogOut.this);
        alart.setTitle("ALERT");
        alart.setMessage("Are you sure exit?");
        alart.setIcon(R.drawable.interrogation);
        alart.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        alart.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(LogIn_LogOut.this, "App not exit yet", Toast.LENGTH_SHORT).show();
            }
        });
        alart.setNeutralButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(LogIn_LogOut.this, "Continue your work", Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog al = alart.create();
        al.show();


    }
    void errormessage()
    {
    led1.setError("Enter UserName");
    led1.requestFocus();
    led2.setError("Enter Password");
    led2.requestFocus();
    return;
    }
}