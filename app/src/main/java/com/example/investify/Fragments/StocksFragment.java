package com.example.investify.Fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.investify.Adapters.AssetRVAdapter;
import com.example.investify.BuyActivity;
import com.example.investify.Classes.Asset;
import com.example.investify.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


public class StocksFragment extends Fragment implements AssetRVAdapter.ItemClickListener{


    private ArrayList<Asset> assetsArrayList;
    ProgressBar loadingPB;


    public StocksFragment() {
        // Required empty public constructor
    }

    public static StocksFragment newInstance() {
        StocksFragment fragment = new StocksFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Activity activity = getActivity();
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_stocks, container, false);
        RecyclerView assetRV = v.findViewById(R.id.idRVAssets);
        loadingPB = v.findViewById(R.id.idProgressBar);

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        // creating our new array list
        assetsArrayList = new ArrayList<>();
        // assetRV.setHasFixedSize(true);
        assetRV.setLayoutManager(new LinearLayoutManager(getContext()));

        // adding our array list to our recycler view adapter class.
        AssetRVAdapter assetRVAdapter = new AssetRVAdapter(assetsArrayList, activity);
        assetRVAdapter.setClickListener(this);
        // setting adapter to our recycler view.
        assetRV.setAdapter(assetRVAdapter);



        // below line is use to get the data from Firebase Firestore.
        // previously we were saving data on a reference of Courses
        // now we will be getting the data from the same reference.
        db.collection("StockList").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        // after getting the data we are calling on success method
                        // and inside this method we are checking if the received
                        // query snapshot is empty or not.
                        if (!queryDocumentSnapshots.isEmpty()) {

                            // if the snapshot is not empty we are
                            // hiding our progress bar and adding
                            // our data in a list.
                            loadingPB.setVisibility(View.GONE);
                            List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                            for (DocumentSnapshot d : list) {
                                // after getting this list we are passing
                                // that list to our object class.
                                String assetCode = (String) d.get("assetCode");
                                String assetName = (String) d.get("assetName");
                                String assetPrice = (String) d.get("assetPrice");
                                Asset a = new Asset(assetCode, assetName, assetPrice);
                                //Asset a = d.toObject(Asset.class);

                                // and we will pass this object class
                                // inside our arraylist which we have
                                // created for recycler view.
                                assetsArrayList.add(a);
                            }
                            // after adding the data to recycler view.
                            // method to notify that data has been changed in recycler view.
                            assetRVAdapter.notifyDataSetChanged();
                        }else {
                            // if the snapshot is empty we are displaying a toast message.
                            Toast.makeText(getActivity(), "No data found in Database", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // if we do not get any data or any error we are displaying
                        // a toast message that we do not get any data
                        Toast.makeText(getActivity(), "Fail to get the data.", Toast.LENGTH_SHORT).show();
                    }
                });
        return v;
    }

    public void onItemClick(View view, int position) {
        Intent i = new Intent(getActivity(), BuyActivity.class);
        Asset asset = assetsArrayList.get(position);
        i.putExtra("asset code", asset.getAssetCode());
        startActivity(i);
    }
}