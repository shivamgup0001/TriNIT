package com.example.trinit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
public class myadapter extends RecyclerView.Adapter<myadapter.ViewHolder> {
    ArrayList<String>a;
    CardView c;

    Context context;
    public myadapter(Context context, ArrayList<String> a) {
        this.a = a;
        this.context=context;

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.rowemp2,parent,false);
        ViewHolder vh=new ViewHolder(v);
        return vh;
    }
    @Override
    public void onBindViewHolder(myadapter.ViewHolder holder, int position){
        String h=a.get(position);
        holder.name.setText(h);

    }
    @Override
    public int getItemCount() {
        return a.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;


        public ViewHolder(View view) {
            super(view);
            c = (CardView) view;
            name = (TextView) view.findViewById(R.id.textView2);
        }

        public TextView getName() {
            return name;
        }
    }
}
