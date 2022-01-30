package com.example.trinit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class EmployeeUI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_ui);
        BottomNavigationView bottomNavigate=findViewById(R.id.bottom_navigation_employee);
        bottomNavigate.setOnNavigationItemSelectedListener(navigateListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_employee,new EmployeeAvailable()).commit();
    } private BottomNavigationView.OnNavigationItemSelectedListener navigateListener=
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment =null;

                    switch(item.getItemId()){
                        case R.id.employeeAvailable:
                            selectedFragment=new EmployeeAvailable();
                            break;
                        case R.id.employeeAssigned:
                            selectedFragment=new EmployeeAssigned();
                            break;
                        case R.id.employeeReport:
                            selectedFragment=new EmployeeReport();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_employee,selectedFragment).addToBackStack(null).commit();
                    return true;
                }
            };
}