package com.example.trinit;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
public class EndUser extends AppCompatActivity {
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference userref = db.collection("users");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_user);
        userref.whereEqualTo("role","Employee").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    for (QueryDocumentSnapshot document : task.getResult()) {
                       Log.d("TAG",document.get("name").toString());
                    }
                }
            }
        });
    }
}