package com.example.investify;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.investify.Adapters.MyAssetsAdapter;
import com.example.investify.Classes.Asset;
import com.example.investify.Classes.User;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MyAssetActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    FirebaseFirestore db;
    RecyclerView rv;
    MyAssetsAdapter ad;
    ArrayList<Asset> assetsArrayList;
    ImageView logo;
    Button menuBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_asset);
        logo = findViewById(R.id.imageView2);
        menuBtn = findViewById(R.id.menuBtn);
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        rv = findViewById(R.id.myAssetRV);

        Glide.with(this)
                .load(R.drawable._logo)
                .fitCenter()
                .into(logo);

        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(MyAssetActivity.this, menuBtn);
                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.popup, popup.getMenu());
                popup.show();
                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        if (item.getTitle().equals("My Assets")){
                            startActivity(new Intent(MyAssetActivity.this, MyAssetActivity.class));
                        }
                        else if (item.getTitle().equals("Buy Assets")){
                            startActivity(new Intent(MyAssetActivity.this, HomeActivity.class));
                        }
                        else if (item.getTitle().equals("Support")){
                            startActivity(new Intent(MyAssetActivity.this, AccountTypeActivity.class));
                        }
                        else if (item.getTitle().equals("Reviews")){
                            startActivity(new Intent(MyAssetActivity.this, ReviewActivity.class));
                        }
                        else{
                            throw new IllegalStateException("Unexpected value: " + item.getTitle());
                        }
                        Toast.makeText(MyAssetActivity.this,"You Clicked : " + item.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
            }
        });

        assetsArrayList = new ArrayList<>();
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));

        ad = new MyAssetsAdapter(assetsArrayList, this);

        // setting adapter to our recycler view.
        rv.setAdapter(ad);

        String uid = mAuth.getCurrentUser().getUid();
        FirebaseFirestore.getInstance().collection("UsersNew").document(uid).get()
                .addOnCompleteListener(task -> {
                    DocumentSnapshot document = task.getResult();
                    User user = document.toObject(User.class);
                    ArrayList<String> getStocks = user.getStocks();
                    Log.d("MY DEBUG: ", String.valueOf(user.getStocks()));
                    ArrayList<String> getCrypto = user.getCrypto();
                    for (String getStock : getStocks) {
                        db.collection("StockList").get()
                                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                                    @Override
                                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                                        if (!queryDocumentSnapshots.isEmpty()) {

                                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                                            for (DocumentSnapshot d : list) {

                                                Asset c = d.toObject(Asset.class);

                                                if (Objects.equals(c.getAssetCode(), getStock)) {
                                                    assetsArrayList.add(c);
                                                }
                                            }
                                            Log.d("My TAG: ", assetsArrayList.toString());
                                            // after adding the data to recycler view.
                                            // method to notify that data has been changed in recycler view.
                                            ad.notifyDataSetChanged();
                                        }else {
                                            // if the snapshot is empty we are displaying a toast message.
                                            Toast.makeText(MyAssetActivity.this, "No data found in Database", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        // if we do not get any data or any error we are displaying
                                        // a toast message that we do not get any data
                                        Toast.makeText(MyAssetActivity.this, "Fail to get the data.", Toast.LENGTH_SHORT).show();
                                    }
                                });
                    }
                    /*
                    for (String getCryp : getCrypto) {
                        db.collection("CryptoList").get()
                                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                                    @Override
                                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                                        if (!queryDocumentSnapshots.isEmpty()) {

                                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                                            for (DocumentSnapshot d : list) {

                                                Asset c = d.toObject(Asset.class);

                                                if (Objects.equals(c.getAssetCode(), getCryp)) {
                                                    assetsArrayList.add(c);
                                                }
                                            }
                                            // after adding the data to recycler view.
                                            // method to notify that data has been changed in recycler view.
                                            ad.notifyDataSetChanged();
                                        }else {
                                            // if the snapshot is empty we are displaying a toast message.
                                            Toast.makeText(MyAssetActivity.this, "No data found in Database", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        // if we do not get any data or any error we are displaying
                                        // a toast message that we do not get any data
                                        Toast.makeText(MyAssetActivity.this, "Fail to get the data.", Toast.LENGTH_SHORT).show();
                                    }
                                });
                    }

                     */
                });
    }
}