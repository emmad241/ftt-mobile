package com.example.investify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class AccountTypeActivity extends AppCompatActivity {

    Button buyDirect;
    Button buyBroker;
    String userType;

    FirebaseAuth mAuth;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_type);

        buyDirect = findViewById(R.id.buyDirect);
        buyBroker = findViewById(R.id.buyBroker);
        mAuth = FirebaseAuth.getInstance();

        buyDirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userType = "Direct";
                addDataToFirestore(userType);
                startActivity(new Intent(AccountTypeActivity.this, HomeActivity.class));
            }
        });

        buyBroker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userType = "Broker";
                addDataToFirestore(userType);
                startActivity(new Intent(AccountTypeActivity.this, HomeActivity.class));
            }
        });
    }

    private void addDataToFirestore(String userType) {
        db = FirebaseFirestore.getInstance();
        String userID = mAuth.getCurrentUser().getUid();
        CollectionReference dbUser = db.collection("UsersNew");
        DocumentReference user = dbUser.document(userID);

        user.update("userType", userType);
    }
}