package com.example.investify;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
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

        buyDirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userType = "Direct";
                String user = mAuth.getCurrentUser().toString();
                addDataToFirestore(user, userType);
                startActivity(new Intent(AccountTypeActivity.this, HomeActivity.class));
            }
        });

        buyBroker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userType = "Broker";
                String user = mAuth.getCurrentUser().toString();
                addDataToFirestore(user, userType);
                startActivity(new Intent(AccountTypeActivity.this, HomeActivity.class));
            }
        });
    }

    private void addDataToFirestore(String user, String userType){
        CollectionReference dbUserTypes = db.collection("UserTypes");
        AccountType accountType = new AccountType(user, userType);
        dbUserTypes.add(accountType).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                // after the data addition is successful
                // we are displaying a success toast message.
                Toast.makeText(AccountTypeActivity.this, "Account Type Saved", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                // this method is called when the data addition process is failed.
                // displaying a toast message when data addition is failed.
                Toast.makeText(AccountTypeActivity.this, "Fail to add account \n" + e, Toast.LENGTH_SHORT).show();
            }
        });
    }
}