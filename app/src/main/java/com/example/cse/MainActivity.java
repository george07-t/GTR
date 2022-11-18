package com.example.cse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button my_button,exit,cal1,li1,gd1,sb1,cdv1,db1,fdb1,sdb1,navib1,reb1;
    private TextView bt_text;
    private AlertDialog.Builder alart;
    private sessionmanager session;


    @Override
    protected void onCreate(Bundle savedIsntanceState){
        super.onCreate(savedIsntanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        my_button =(Button) findViewById(R.id.button2);
        bt_text=(TextView) findViewById(R.id.textView2);
        cal1=(Button)findViewById(R.id.cal1);
        exit=(Button) findViewById(R.id.exit);
        li1=(Button)findViewById(R.id.l1);
        gd1=(Button)findViewById(R.id.gd1);
        sb1=(Button)findViewById(R.id.sb1);
        cdv1=(Button) findViewById(R.id.cdv1);
        db1=(Button)findViewById(R.id.db1);
        fdb1=(Button)findViewById(R.id.fdb1);
        sdb1=(Button)findViewById(R.id.sdb1);
        navib1=(Button)findViewById(R.id.navib1);
        reb1=(Button)findViewById(R.id.reb1);
        bt_text.setVisibility(View.VISIBLE);
        reb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,MyRecyclerView.class);
                startActivity(intent);
            }
        });
        navib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SCREEN_NAVIGATION.class);
                startActivity(intent);
            }
        });
        session=new sessionmanager(getApplicationContext());
        sdb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this, SQLDataBaseExample.class);
                startActivity(intent);
            }
        });
        fdb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this, FileStorageExample.class);
                startActivity(intent);
            }
        });
        db1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this, DatabaseExample.class);
                startActivity(intent);
            }
        });
        cdv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this, CardViewExample.class);
                startActivity(intent);
            }
        });
        gd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this, GridViewExample.class);
                startActivity(intent);
            }
        });
        sb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this, SpinnerExample.class);
                startActivity(intent);
            }
        });

        my_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent =new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this,"WELCOME TO CSE",Toast.LENGTH_SHORT).show();
            }
        });
        cal1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,calculator.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "CALCULATOR", Toast.LENGTH_SHORT).show();
            }
        });
        li1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, ListViewSample.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this, "LISTVIEW", Toast.LENGTH_SHORT).show();
            }
        });


        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alart = new AlertDialog.Builder(MainActivity.this);
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
                        Toast.makeText(MainActivity.this, "App not exit yet", Toast.LENGTH_SHORT).show();
                    }
                });
                alart.setNeutralButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "Continue your work", Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog al = alart.create();
                al.show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater= getMenuInflater();
        menuInflater.inflate(R.menu.menu_example,menu);


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.f1)
        {
            Toast.makeText(MainActivity.this, "Setings is clicked", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if(item.getItemId()==R.id.f2)
        {
            Intent intent=new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            String subject="CSE APP";
            String body="This app help for Developers. \n   com.example.cse";
            intent.putExtra(Intent.EXTRA_SUBJECT,subject);
            intent.putExtra(Intent.EXTRA_TEXT,body);
            startActivity(Intent.createChooser(intent,"Share With"));
            return true;
        }
        else if(item.getItemId()==R.id.f3)
        {
            Toast.makeText(MainActivity.this, "About us", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(MainActivity.this,MainActivity2.class);
            startActivity(intent);
            return true;
        }
        else if(item.getItemId()==R.id.f4)
        {
            Toast.makeText(MainActivity.this, "Feedback", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(MainActivity.this,FeedbackActivity.class);
            startActivity(intent);
        }
        else if(item.getItemId()==R.id.f5)
        {
            session.setLogin(false);
            Intent intent= new Intent(MainActivity.this,LogIn_LogOut.class);
            startActivity(intent);
            Toast.makeText(getApplicationContext(), "Log Out Successfully", Toast.LENGTH_SHORT).show();
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

                    alart = new AlertDialog.Builder(MainActivity.this);
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
                            Toast.makeText(MainActivity.this, "App not exit yet", Toast.LENGTH_SHORT).show();
                        }
                    });
                    alart.setNeutralButton("cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(MainActivity.this, "Continue your work", Toast.LENGTH_SHORT).show();
                        }
                    });
                    AlertDialog al = alart.create();
                    al.show();


    }
}