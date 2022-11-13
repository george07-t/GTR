package com.example.cse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;


public class GridViewExample extends AppCompatActivity {
    private GridView gv1;
    int logo[]={R.drawable.ak,R.drawable.al,R.drawable.ar,R.drawable.az,
            R.drawable.ca,R.drawable.co,R.drawable.ct,R.drawable.de,R.drawable.fl,
            R.drawable.ga};
    String[] dept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        gv1= (GridView)findViewById(R.id.gv1);
        dept=getResources().getStringArray(R.array.DepartmentName);
        CustomAdapter adapter=new CustomAdapter(this,dept,logo);
        gv1.setAdapter(adapter);
        gv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String val=dept[i];
                Toast.makeText(GridViewExample.this, val+" "+i, Toast.LENGTH_SHORT).show();

            }
        });
    }
}