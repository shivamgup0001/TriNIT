package com.example.trinit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class LeadReportedBugs extends AppCompatActivity {
    RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lead_reported_bugs);
        MainActivity.check=7;
        recyclerView=findViewById(R.id.leadReportsRecycler);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(LeadReportedBugs.this));
        recyclerViewAdapter=new RecyclerViewAdapter(LeadReportedBugs.this);
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}