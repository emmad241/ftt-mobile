package com.example.investify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.investify.Classes.Asset;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;
import java.util.Objects;

public class BuyActivity extends AppCompatActivity {

    TextView stCode, cPrice;
    Button buyBtn;
    FirebaseAuth mAuth;
    FirebaseFirestore db;
    String stCodeStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);
        stCode = findViewById(R.id.stCode);
        buyBtn = findViewById(R.id.payRequest);
        cPrice = findViewById(R.id.cPrice);
        Intent i = getIntent();
        stCodeStr = i.getStringExtra("asset code");
        stCode.setText(stCodeStr);
        db = FirebaseFirestore.getInstance();
        db.collection("StockList").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                        if (!queryDocumentSnapshots.isEmpty()) {

                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                            for (DocumentSnapshot d : list) {
                                Asset a = d.toObject(Asset.class);

                                if (Objects.equals(a.getAssetCode(), stCodeStr)){
                                    cPrice.setText(a.getAssetPrice());
                                }
                            }
                        }else {
                            Toast.makeText(BuyActivity.this, "No data found in Database", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(BuyActivity.this, "Fail to get the data.", Toast.LENGTH_SHORT).show();
                    }
                });
        buyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth = FirebaseAuth.getInstance();
                String userID = mAuth.getCurrentUser().getUid();
                addAssetToFirestore(userID, stCodeStr);
                Intent i = new Intent(BuyActivity.this, MyAssetActivity.class);
                startActivity(i);
            }
        });
    }
    private void addAssetToFirestore(String userID, String assetCode) {
        db = FirebaseFirestore.getInstance();
        CollectionReference dbUser = db.collection("UsersNew");
        DocumentReference user = dbUser.document(userID);

        user.update("stocks", FieldValue.arrayUnion(assetCode));
    }

}