package com.example.trinit;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class EmployeeAssigned extends Fragment {
    RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       MainActivity.check=3;
       View view= inflater.inflate(R.layout.fragment_employee_assigned, container, false);
        recyclerView=view.findViewById(R.id.employeeAssignedRecycler);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewAdapter=new RecyclerViewAdapter(getContext());
        recyclerView.setAdapter(recyclerViewAdapter);
       return view;
    }
}