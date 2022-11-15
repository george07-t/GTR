package com.example.cse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class FileStorageExample extends AppCompatActivity {
private Button fdb2;
private EditText fed1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_storage_example);
        fdb2=(Button) findViewById(R.id.fdb2);
        fed1=(EditText) findViewById(R.id.fed1);

        fdb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ed=fed1.getText().toString();
                if(ed.equals(""))
                {

                    Toast.makeText(FileStorageExample.this, "Enter Data", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    filewrite(ed);
                }
            }
        });
        fileread();
    }
    public void filewrite(String txt)
    {
        try (FileOutputStream fileOutputStream = openFileOutput("Input.txt", Context.MODE_PRIVATE)) {
            fileOutputStream.write(txt.getBytes());
            fileOutputStream.close();
            Toast.makeText(getApplicationContext(), "Data write successfully", Toast.LENGTH_SHORT).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fileread()
    {
        try {
            FileInputStream fileInputStream=openFileInput("Input.txt");
            InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            String line;
            StringBuffer stringBuffer=new StringBuffer();
            while ((line=bufferedReader.readLine())!=null)
            {
                stringBuffer.append(line+"\n");
            }
            fed1.setText(stringBuffer.toString());
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}