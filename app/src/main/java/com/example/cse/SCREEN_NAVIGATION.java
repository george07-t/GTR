package com.example.cse;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class SCREEN_NAVIGATION extends AppCompatActivity {
    private TabLayout tl1;
    private ViewPager vp1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_navigation);
        tl1=(TabLayout) findViewById(R.id.tabl1);
        vp1=(ViewPager) findViewById(R.id.vp1);
        vp1.setAdapter(new mypage(getSupportFragmentManager()));
        tl1.setupWithViewPager(vp1);
        tl1.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vp1.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }
class mypage extends FragmentPagerAdapter{
String[] text={"Bangladesh","India","Pakistan"};
    public mypage(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position==0)
        {
            return new BangladeshFrag();
        }
       else if(position==1)
        {
            return new IndiaFrag();
        }
        else if(position==2)
        {
            return new PakistanFrag();
        }
        return null;
    }

    @Override
    public int getCount() {
        return text.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return text[position];
    }
}
}