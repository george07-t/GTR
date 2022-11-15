package com.example.cse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class DatabaseExample extends AppCompatActivity implements View.OnClickListener {
    private Button dbd1,dbd2;
    private EditText ded1,ded2;
    private TextView dt1;
    private LinearLayout ll1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_example);
        dbd1=(Button) findViewById(R.id.dbd1);
        dbd2=(Button) findViewById(R.id.dbd2);
        ded1=(EditText) findViewById(R.id.ded1);
        ded2=(EditText) findViewById(R.id.ded2);
        dt1=(TextView) findViewById(R.id.dt1);
        ll1=(LinearLayout)findViewById(R.id.ll1);
        if(loadcolor()!=getResources().getColor(R.color.material_pink))
        {
            ll1.setBackgroundColor(loadcolor());
        }

        dt1.setVisibility(View.INVISIBLE);
        dbd1.setOnClickListener(this);
        dbd2.setOnClickListener(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater= getMenuInflater();
        menuInflater.inflate(R.menu.save_color_menu,menu);


        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.rcm)
        {
            ll1.setBackgroundColor(getResources().getColor(R.color.red));
            storecolor(getResources().getColor(R.color.red));
            return true;
        }
        else if(item.getItemId()==R.id.gcm)
        {
            ll1.setBackgroundColor(getResources().getColor(R.color.green));
            storecolor(getResources().getColor(R.color.green));
            return true;
        }
        else if(item.getItemId()==R.id.bcm)
        {
            ll1.setBackgroundColor(getResources().getColor(R.color.blue));
            storecolor(getResources().getColor(R.color.blue));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void storecolor(int color)
    {
        SharedPreferences preferences1=getSharedPreferences("StoreBackgroundColor", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor1=preferences1.edit();
        editor1.putInt("mycolor",color);
        editor1.commit();


    }
    public int loadcolor()
    {
        SharedPreferences preferences1=getSharedPreferences("StoreBackgroundColor", Context.MODE_PRIVATE);
        int selectcolor=preferences1.getInt("mycolor",getResources().getColor(R.color.material_pink));
        return selectcolor;
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.dbd1)
        {
            String user=ded1.getText().toString();
            String pass=ded2.getText().toString();
            if(user.equals("")&& pass.equals(""))
            {
                Toast.makeText(DatabaseExample.this, "INVALID", Toast.LENGTH_SHORT).show();
            }
            else{
                //write data
            SharedPreferences preferences=getSharedPreferences("UserDetails", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor=preferences.edit();//data write
            editor.putString("userKey",user);
            editor.putString("passKey",pass);
            editor.commit();
            ded1.getText().clear();
            ded2.getText().clear();
                Toast.makeText(getApplicationContext(), "Data Stored Successfully", Toast.LENGTH_SHORT).show();
            }
        }
        else if(view.getId()==R.id.dbd2)
        {
            //to read
            SharedPreferences preferences=getSharedPreferences("UserDetails", Context.MODE_PRIVATE);
            if(preferences.contains("userKey")&& preferences.contains("passKey"))
            {
                String username=preferences.getString("userKey","Data Not Found");
                String  password=preferences.getString("passKey","Data Not Found");
                if(username.equals("")&&password.equals(""))
                {
                    dt1.setVisibility(View.INVISIBLE);
                }
                else{
                dt1.setVisibility(View.VISIBLE);
                dt1.setText("UserName = "+username +"\n Password = "+password );}
            }
        }
    }
}