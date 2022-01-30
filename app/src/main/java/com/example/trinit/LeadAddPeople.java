package com.example.trinit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class LeadAddPeople extends AppCompatActivity {
    RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lead_add_people);
        MainActivity.check=5;
        recyclerView=findViewById(R.id.leadAddRoleRecycler);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(LeadAddPeople.this));
        recyclerViewAdapter=new RecyclerViewAdapter(LeadAddPeople.this);
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}