package com.example.cse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MyRecyclerView extends AppCompatActivity {
   RecyclerView rec1;
    int[] images ={R.drawable.ak,R.drawable.al,R.drawable.ar,R.drawable.az,
            R.drawable.ca,R.drawable.co,R.drawable.ct,R.drawable.de,R.drawable.fl,
            R.drawable.ga};
    String[] title,description;
    MyRecycleAdapter myRecycleAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_recycler_view);
        rec1=(RecyclerView) findViewById(R.id.rec1);
        title=getResources().getStringArray(R.array.Department_List);
        description=getResources().getStringArray(R.array.Department_Details);
        myRecycleAdapter=new MyRecycleAdapter(this,title,description,images);
        rec1.setAdapter(myRecycleAdapter);
        rec1.setLayoutManager(new LinearLayoutManager(this));
        myRecycleAdapter.setOnItemClickListner(new MyRecycleAdapter.ClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Toast.makeText(getApplicationContext(), "OnItem Click"+(position+1), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onItemLongClick(int position, View v) {
                Toast.makeText(getApplicationContext(), "OnItemLong Click"+(position+1), Toast.LENGTH_SHORT).show();
            }
        });
    }
}