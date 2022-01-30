package com.example.trinit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    LayoutInflater inflater;
    private int size=15;
    public RecyclerViewAdapter(Context context) {
        this.inflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(MainActivity.check==1) {
            View view = inflater.inflate(R.layout.rowuser, parent, false);
            return new ViewHolder(view);
        }
        if(MainActivity.check==2) {
            View view = inflater.inflate(R.layout.rowemp1, parent, false);
            return new ViewHolder(view);
        }
        if(MainActivity.check==3) {
            View view = inflater.inflate(R.layout.rowemp2, parent, false);
            return new ViewHolder(view);
        }
        if(MainActivity.check==4){
            View view = inflater.inflate(R.layout.rowlead, parent, false);
            return new ViewHolder(view);
        }
        if(MainActivity.check==5){
            View view = inflater.inflate(R.layout.rowleadadd, parent, false);
            return new ViewHolder(view);
        }
        if(MainActivity.check==6){
            View view = inflater.inflate(R.layout.rowleadrequest, parent, false);
            return new ViewHolder(view);
        }
        if(MainActivity.check==7){
            View view = inflater.inflate(R.layout.rowleadreport, parent, false);
            return new ViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return size;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
