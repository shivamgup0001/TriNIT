package com.example.trinit;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.auth.internal.zzx;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
public class MainActivity extends AppCompatActivity {
    public static int check=0;
    SignInButton signInButton;
    GoogleSignInClient mGoogleSignInClient;
    FirebaseAuth mAuth=FirebaseAuth.getInstance();
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference userref = db.collection("users");
    private String TAG;
    ProgressBar pg;
    Button signupbtn;
    FirebaseUser user;
    private GoogleSignInAccount GoogleSignInAccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signInButton = (SignInButton) findViewById(R.id.button);
        signupbtn = (Button) findViewById(R.id.signup_btn);
        pg = (ProgressBar) findViewById(R.id.pgbar);
        pg.setVisibility(View.INVISIBLE);
        mAuth = FirebaseAuth.getInstance();
        Log.d("TAG","hgfdghjkjjhgvcnmbv999");

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        Log.d("TAG","hgfdghjkjjhgvcnmbv98765");

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        Log.d("TAG","hgfdghjkjjhgvcnmbv456789");
        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Intent it =new Intent(MainActivity.this,chooser.class);
             startActivity(it);
            }
        });
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signInIntent = mGoogleSignInClient.getSignInIntent();
                Log.d("TAG","hgfdghjkjjhgvcnmbv14567876");

                startActivityForResult(signInIntent, 90);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        pg.setVisibility(View.INVISIBLE);
        user =mAuth.getCurrentUser();
        updateUI(user);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d("TAG","hgfdghjkjjhgvcnmbv14567");

        if (requestCode == 90) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            Log.d("TAG","hgfdghjkjjhgvcnmbv4");

            handleSignInResult(task);
        }
    }

    private void firebaseAuthWithGoogle(String idToken) {

    }

    void updateUI(FirebaseUser user) {
        if(user!=null){
            pg.setVisibility(View.VISIBLE);
            userref.document(user.getEmail()).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    if(documentSnapshot.exists()){
                        String s=documentSnapshot.get("role").toString();
                        if(s.equals("Organisation Lead")){
                            Intent it=new Intent(MainActivity.this,OrganisationLead.class);
                            startActivity(it);
                            finish();
                        }
                        else if(s.equals("Employee")){
                            Intent it=new Intent(MainActivity.this,EmployeeUI.class);
                            startActivity(it);
                            finish();
                        }
                        else if(s.equals("User")){
                            Intent it=new Intent(MainActivity.this,UserUI.class);
                            startActivity(it);
                            finish();
                        }
                    }
                    else{
                        pg.setVisibility(View.INVISIBLE);
                        Toast.makeText(MainActivity.this,"Please SignUp First",Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
        else{

        }}
    private void handleSignInResult(Task<GoogleSignInAccount> task) {
        try {
            Log.d("TAG","hgfdghjkjjhgvcnmbv1"+task);

            GoogleSignInAccount account = task.getResult(ApiException.class);
            Log.d("TAG","hgfdghjkjjhgvcnmbv2");

            AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
            Log.d("TAG","hgfdghjkjjhgvcnmbv3");
            mAuth.signInWithCredential(credential)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                user = mAuth.getCurrentUser();
                                updateUI(user);
                            }
                        }
                    });
        } catch (ApiException e) {
            Toast.makeText(MainActivity.this, "Sign in failed.....!!", Toast.LENGTH_LONG).show();
            Log.d("TAG","hgfdghjkjjhgvcnmbvhgghg77888");
        }
    }
}