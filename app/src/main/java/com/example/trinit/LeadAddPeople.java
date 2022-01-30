package com.example.trinit;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
public class LeadAddPeople extends AppCompatActivity {
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference userref = db.collection("users");
    ArrayList<String>a;
    RecyclerView rc;
    myadapter ad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lead_add_people);
        rc=(RecyclerView)findViewById(R.id.recyclerview);
        rc.setHasFixedSize(true);
        a=new ArrayList<>();
          ad=new myadapter(this,a);
          rc.setLayoutManager(new LinearLayoutManager(this));
          rc.setAdapter(ad);
        userref.whereEqualTo("role","Employee").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        a.add(document.get("name").toString());
                    }
                    ad.notifyDataSetChanged();
                }
            }
        });
    }
    }
