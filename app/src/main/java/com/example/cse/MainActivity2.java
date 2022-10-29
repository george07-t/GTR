package com.example.cse;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    private AlertDialog.Builder alart;
    private Button exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        exit=(Button) findViewById(R.id.exit) ;
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alart=new AlertDialog.Builder(MainActivity2.this);
                alart.setTitle("Warning");
                alart.setMessage("Go back?");
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
                        Toast.makeText(MainActivity2.this, "App not exit yet", Toast.LENGTH_SHORT).show();
                    }
                });
                alart.setNeutralButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity2.this, "Continue your work", Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog al=alart.create();
                al.show();
            }
        });
    }

}