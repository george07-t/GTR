package com.example.cse;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button my_button,b2,b3,exit;
    private TextView my_text,bt_text,t3;
    private EditText ed1,ed2;
    private AlertDialog.Builder alart;


    @Override
    protected void onCreate(Bundle savedIsntanceState){
        super.onCreate(savedIsntanceState);
        setContentView(R.layout.activity_main);
        my_button =(Button) findViewById(R.id.button2);
        my_text=(TextView) findViewById(R.id.textView);
        bt_text=(TextView) findViewById(R.id.textView2);
        b2=(Button) findViewById(R.id.b2);
        b3=(Button) findViewById(R.id.b3) ;
        exit=(Button) findViewById(R.id.exit) ;
        ed1=(EditText) findViewById(R.id.num1);
        ed2=(EditText) findViewById(R.id.num2);
        t3=(TextView) findViewById(R.id.t3);
        bt_text.setVisibility(View.VISIBLE);

        my_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent =new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
                Toast.makeText(MainActivity.this,"WELCOME TO CSE",Toast.LENGTH_SHORT).show();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String num1=ed1.getText().toString();
                    String num2=ed2.getText().toString();
                    Double n1=Double.parseDouble(num1);
                    Double n2=Double.parseDouble(num2);
                    Double sum=n1+n2;
                    t3.setText("SUM="+sum);
                }catch (Exception e)
                {
                    Toast.makeText(MainActivity.this, "ENTER NUMBER TO SUM", Toast.LENGTH_SHORT).show();
                }

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String num1=ed1.getText().toString();
                    String num2=ed2.getText().toString();
                    Double n1=Double.parseDouble(num1);
                    Double n2=Double.parseDouble(num2);
                    Double sum=n1-n2;
                    t3.setText("SUB="+sum);
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "ENTER NUMBER SUB", Toast.LENGTH_SHORT).show();
                }

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