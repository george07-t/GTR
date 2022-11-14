package com.example.cse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class SplashScreen extends AppCompatActivity {
private ProgressBar pg2;
int progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //HIDE ACTION BAR
        getSupportActionBar().hide();
        //HIDE TITLE BAR
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        pg2=(ProgressBar) findViewById(R.id.pg2);
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {

                dowork();
                startApp();
            }

        });
        thread.start();
    }
    public void dowork()
    {
        for(progress=20;progress<=100;progress=progress+20) {
            try {
                Thread.sleep(1000);
                pg2.setProgress(progress);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    public void startApp()
    {
        Intent intent=new Intent(SplashScreen.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}