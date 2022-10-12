package com.example.investify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    Button loginBtn;
    Button regButton;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginBtn = findViewById(R.id.mainLoginBtn);
        regButton = findViewById(R.id.mainRegBtn);

        mAuth = FirebaseAuth.getInstance();

        loginBtn.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this,LoginActivity.class));
        });
        regButton.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this,RegisterActivity.class));
        });
    }
/*
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser == null){
            startActivity(new Intent(MainActivity.this,LoginActivity.class));
        }
    }
    */
}