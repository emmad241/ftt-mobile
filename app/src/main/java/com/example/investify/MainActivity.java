package com.example.investify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    ImageView ivTitle;
    ImageView ivGraph;
    Button loginBtn;
    Button regButton;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginBtn = findViewById(R.id.mainLoginBtn);
        regButton = findViewById(R.id.mainRegBtn);
        ivTitle = findViewById(R.id.ivTitle);
        ivGraph = findViewById(R.id.ivGraph);

        mAuth = FirebaseAuth.getInstance();

        loginBtn.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this,LoginActivity.class));
            finish();
        });

        regButton.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this,RegisterActivity.class));
            finish();
        });

        Glide.with(this)
                .load(R.drawable._logo)
                .fitCenter()
                .into(ivTitle);

        Glide.with(this)
                .load(R.drawable.graph)
                .fitCenter()
                .into(ivGraph);
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser == null){
            startActivity(new Intent(MainActivity.this,LoginActivity.class));
        }
    }

}