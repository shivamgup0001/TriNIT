package com.example.trinit;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
public class LeadRequests extends AppCompatActivity {
    RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lead_requests);
        MainActivity.check=6;
        recyclerView=findViewById(R.id.leadRequestsRecycler);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(LeadRequests.this));
        recyclerViewAdapter=new RecyclerViewAdapter(LeadRequests.this);
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}