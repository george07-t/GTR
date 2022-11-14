package com.example.cse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

public class SpinnerExample extends AppCompatActivity {
    private Button ssb1;
    private TextView sst1;
    private Spinner sp1,sp2;
    String[] dept;
    int progress;
    private ProgressBar pg1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_example);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        ssb1=(Button) findViewById(R.id.ssb1);
        sst1=(TextView) findViewById(R.id.sst1);
        dept=getResources().getStringArray(R.array.DeptSelect);
        sp1=(Spinner) findViewById(R.id.sp1);
        sp2=(Spinner) findViewById(R.id.sp2);
        pg1=(ProgressBar)findViewById(R.id.pg1);
        pg1.setVisibility(View.INVISIBLE);
        ArrayAdapter<String> adapter=new ArrayAdapter<>(SpinnerExample.this,R.layout.list_sample,R.id.txt2,dept);
        sp1.setAdapter(adapter);
        sp2.setAdapter(adapter);

        ssb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spin();
                prog();

            }
        });
    }

/*    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==android.R.id.home)
        {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }*/

    public void prog()
    {
        String val1=sp1.getSelectedItem().toString();
        String val2=sp2.getSelectedItem().toString();
        String res=val1+"-"+val2;
        sst1.setText("You Searched = "+res);
    }
    public void spin()
    {
        pg1.setVisibility(View.VISIBLE);
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                dowork();
            }

        });
        thread.start();

    }
    public void dowork()
    {
        for(progress=10;progress<=100;progress=progress+20) {
            try {
                Thread.sleep(1000);
                pg1.setProgress(progress);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}