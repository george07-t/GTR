package com.example.cse;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    int[] logo;
    String[] dept;
    Context context;

    CustomAdapter(Context context,String[] department,int[] flags){
    this.context=context;
    this.dept=department;
    this.logo=flags;
    }
    @Override
    public int getCount() {
        return dept.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
                 view = inflater.inflate(R.layout.sample_grid_view,viewGroup,false);
        }
       ImageView imageView=(ImageView) view.findViewById(R.id.im1);
        TextView textView=(TextView) view.findViewById(R.id.gt1);
        imageView.setImageResource(logo[i]);
        textView.setText(dept[i]);
        return view;
    }
}
