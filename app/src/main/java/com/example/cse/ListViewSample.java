package com.example.cse;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

public class ListViewSample extends AppCompatActivity {
    private ListView l1;
    private SearchView sr1;
    ArrayAdapter<String> adapter;
    String[] department;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
       l1=(ListView) findViewById(R.id.list1);
       // sr1=(SearchView)findViewById(R.id.sr1);
        department =getResources().getStringArray(R.array.Department_Name);
        //adapter=new ArrayAdapter<>(ListViewSample.this,R.layout.list_sample,R.id.txt2,department);
        adapter=new ArrayAdapter<String>(  this,
                android.R.layout.simple_list_item_1,department);


        l1.setAdapter(adapter);
        l1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Fragment fragment;
                if(i==0)
                {
                    fragment=new CSEFragment();
                    FragmentManager fragmentManager=getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fg1,fragment);
                    fragmentTransaction.commit();
                }
                else if(i==1)
                {

                    fragment=new EEEFragment();
                    getFragmentManager().beginTransaction().replace(R.id.fg1,fragment).commit();
                }
                else
                {
                    String val= (String) adapter.getItem(i);
                    Toast.makeText(ListViewSample.this, val+" "+(i+1), Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater= getMenuInflater();
        menuInflater.inflate(R.menu.listmenu,menu);
        MenuItem menuItem=menu.findItem(R.id.lf1);
        SearchView searchView= (SearchView) menuItem.getActionView();


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String st) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String st2) {
                adapter.getFilter().filter(st2);

                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}