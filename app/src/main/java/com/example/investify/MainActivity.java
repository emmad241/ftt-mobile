package com.example.investify;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    ImageView ivTitle;
    ImageView ivGraph;
    Button loginBtn;
    Button regButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginBtn = findViewById(R.id.mainLoginBtn);
        regButton = findViewById(R.id.mainRegBtn);
        ivTitle = findViewById(R.id.ivTitle);
        ivGraph = findViewById(R.id.ivGraph);


        loginBtn.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
        });

        regButton.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, RegisterActivity.class));
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

}