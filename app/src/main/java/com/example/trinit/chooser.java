package com.example.trinit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class chooser extends AppCompatActivity {
    CardView organisationlead,employee,usercard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooser);
        organisationlead=(CardView)findViewById(R.id.organisation_lead_card);
        employee=(CardView)findViewById(R.id.employee_card);
        usercard=(CardView)findViewById(R.id.user_card);
        organisationlead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(chooser.this,signup.class);
                it.putExtra("role","Organisation Lead");
                startActivity(it);
                finish();
            }
        });
        employee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(chooser.this,signup.class);
                it.putExtra("role","Employee");
                finish();
                startActivity(it);
            }
        });
        usercard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(chooser.this,signup.class);
                it.putExtra("role","User");
                finish();
                startActivity(it);
            }
        });

    }
}
