package com.example.trinit;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
public class signup extends AppCompatActivity {
    EditText namei,emaili,rolei;
    String name,email,role;
    Button b;
    FirebaseAuth mAuth=FirebaseAuth.getInstance();
    FirebaseUser firebaseUser=mAuth.getCurrentUser();
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference userref = db.collection("users");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        namei=(EditText)findViewById(R.id.name);
        emaili=(EditText)findViewById(R.id.email);
        b=(Button)findViewById(R.id.button4);
        firebaseUser=mAuth.getCurrentUser();
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setfields();
                user u=new user(name,role,email);
                signup(u);

            }
        });}
    private void signup(user u){
        userref.document(u.getEmail()).set(u).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(signup.this,"Signed up successfully...",Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
    private void setfields() {
        name=namei.getText().toString();
        email=emaili.getText().toString();
        Intent it=getIntent();
        role=it.getStringExtra("role");
    }
}