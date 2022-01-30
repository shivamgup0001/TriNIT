package com.example.trinit;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.getbase.floatingactionbutton.FloatingActionButton;
public class OrganisationLead extends AppCompatActivity {
    FloatingActionButton b1,b2,b3;
    RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivity.check=4;
        setContentView(R.layout.activity_organisation_lead);
        b1=findViewById(R.id.addPeople);
        b2=findViewById(R.id.requests);
        b3=findViewById(R.id.reportedBugs);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(OrganisationLead.this,LeadAddPeople.class);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(OrganisationLead.this,LeadRequests.class);
                startActivity(i);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(OrganisationLead.this,LeadReportedBugs.class);
                startActivity(i);
            }
        });
        recyclerView=findViewById(R.id.organisationLeadRecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(OrganisationLead.this));
        recyclerViewAdapter=new RecyclerViewAdapter(OrganisationLead.this);
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}