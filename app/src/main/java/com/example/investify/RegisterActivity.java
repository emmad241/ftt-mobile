package com.example.investify;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.investify.Classes.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Objects;

public class RegisterActivity extends AppCompatActivity {

    Button regBtn;
    TextView tvLoginHere;
    EditText regEmail;
    EditText regPassword;
    private FirebaseFirestore db;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();


        regBtn = findViewById(R.id.regBtn);
        tvLoginHere = findViewById(R.id.tvLoginhere);
        regEmail = findViewById(R.id.regEditEmail);
        regPassword = findViewById(R.id.regPassword1);

        regBtn.setOnClickListener(view -> {
            createUser();
        });

        tvLoginHere.setOnClickListener(view -> {
            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
        });
    }

    private void createUser(){
        String email = regEmail.getText().toString();
        String password = regPassword.getText().toString();

        if (TextUtils.isEmpty(email)){
            regEmail.setError("Email cannot be empty");
            regEmail.requestFocus();
        }else if (TextUtils.isEmpty(password)){
            regPassword.setError("Password cannot be empty");
            regPassword.requestFocus();
        }else{
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        addDataToFirestore(email);
                        Toast.makeText(RegisterActivity.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegisterActivity.this, MyAssetActivity.class));
                        finish();
                    } else {
                        Toast.makeText(RegisterActivity.this, "Registration Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
    private void addDataToFirestore(String username) {
        db = FirebaseFirestore.getInstance();
        CollectionReference dbUser = db.collection("UsersNew");
        String userType = "";
        ArrayList<String> stocks = new ArrayList<>();
        ArrayList<String> crypto = new ArrayList<>();
        User user = new User(username, userType, stocks, crypto);
        Log.d("MY DEBUG", "Successful function");
        dbUser.document(Objects.requireNonNull(mAuth.getUid())).set(user);
    }
}