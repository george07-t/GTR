package com.example.cse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FeedbackActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edf1, edf2;
    private Button bf1, bf2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        edf1 = (EditText) findViewById(R.id.edf1);
        edf2 = (EditText) findViewById(R.id.edf2);
        bf1 = (Button) findViewById(R.id.bf1);
        bf2 = (Button) findViewById(R.id.bf2);
        bf1.setOnClickListener(this);
        bf2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        try {
            String name = edf1.getText().toString();
            String feedback = edf2.getText().toString();
            if (view.getId() == R.id.bf1) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/email");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"georgetonmoy07@gmail.com", "roy1907114@kstud.kuet.ac.bd"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "FEEDBACK FORM THE USER");
                intent.putExtra(Intent.EXTRA_TEXT, "Name=" + name + "\n Feedback" + feedback);
                startActivity(Intent.createChooser(intent, "Feedback With"));
            } else if (view.getId() == R.id.bf2) {
                edf1.setText("");
                edf2.setText("");

            }
        } catch (Exception e) {
            Toast.makeText(FeedbackActivity.this, "INVALID", Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(),"Execption"+e,Toast.LENGTH_SHORT).show();
        }
    }
}