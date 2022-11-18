package com.example.cse;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyRecycleAdapter extends RecyclerView.Adapter<MyRecycleAdapter.MyViewHolder>
{
    Context context;
    String[]title,des;
    int[]images;
    private static ClickListener clickListener;

    public MyRecycleAdapter(Context context, String[] title, String[] des, int[] images) {
        this.context = context;
        this.title = title;
        this.des = des;
        this.images = images;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
       View view= layoutInflater.inflate(R.layout.my_recycle_list,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tt1.setText(title[position]);
        holder.dt1.setText(des[position]);
        holder.recim1.setImageResource(images[position]);

    }

    @Override
    public int getItemCount() {
        return title.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener
    {
        TextView tt1,dt1;
        ImageView recim1;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tt1=itemView.findViewById(R.id.ret1);
            dt1=itemView.findViewById(R.id.ret2);
            recim1=itemView.findViewById(R.id.rim1);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);

        }

        @Override
        public void onClick(View view) {
            clickListener.onItemClick(getAdapterPosition(),view);
        }

        @Override
        public boolean onLongClick(View view) {
            clickListener.onItemLongClick(getAdapterPosition(),view);
            return false;
        }
    }
    public interface ClickListener{
        void onItemClick(int position,View v);
        void onItemLongClick(int position,View v);
    }
    public void setOnItemClickListner(ClickListener clickListener){
        MyRecycleAdapter.clickListener=clickListener;
    }
}
