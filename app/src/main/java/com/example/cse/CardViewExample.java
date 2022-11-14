package com.example.cse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class CardViewExample extends AppCompatActivity implements View.OnClickListener {
    private CardView sc,hc,ac,rc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view_example);
        sc=(CardView) findViewById(R.id.scv1);
        hc=(CardView) findViewById(R.id.hcv2);
        ac=(CardView) findViewById(R.id.acv3);
        rc=(CardView) findViewById(R.id.rcv4);
        sc.setOnClickListener(this);
        hc.setOnClickListener(this);
        ac.setOnClickListener(this);
        rc.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.scv1)
        {

            Toast.makeText(CardViewExample.this, "WELCOME TO SCHOOL", Toast.LENGTH_SHORT).show();
        }
       else if(view.getId()==R.id.hcv2)
        {
            Toast.makeText(CardViewExample.this, "WELCOME TO HOSPITAL", Toast.LENGTH_SHORT).show();
        }
        else if(view.getId()==R.id.acv3)
        {
            Toast.makeText(CardViewExample.this, "WELCOME TO AIRPORT", Toast.LENGTH_SHORT).show();
        }
        else if(view.getId()==R.id.rcv4)
        {
            Toast.makeText(CardViewExample.this, "WELCOME TO RESTAURENT", Toast.LENGTH_SHORT).show();
        }
    }
}