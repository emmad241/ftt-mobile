package com.example.investify;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


public class CryptoFragment extends Fragment {

    private RecyclerView assetRV;
    private ArrayList<Asset> assetsArrayList;
    private AssetRVAdapter assetRVAdapter;
    private FirebaseFirestore db;
    ProgressBar loadingPB;


    public CryptoFragment() {
        // Required empty public constructor
    }


    public static CryptoFragment newInstance() {
        CryptoFragment fragment = new CryptoFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_crypto, container, false);
        assetRV = v.findViewById(R.id.idRVAssets);
        loadingPB = v.findViewById(R.id.idProgressBar);

        db = FirebaseFirestore.getInstance();

        // creating our new array list
        assetsArrayList = new ArrayList<>();
        assetRV.setHasFixedSize(true);
        assetRV.setLayoutManager(new LinearLayoutManager(getActivity()));

        // adding our array list to our recycler view adapter class.
        assetRVAdapter = new AssetRVAdapter(assetsArrayList, getActivity());

        // setting adapter to our recycler view.
        assetRV.setAdapter(assetRVAdapter);

        // below line is use to get the data from Firebase Firestore.
        // previously we were saving data on a reference of Courses
        // now we will be getting the data from the same reference.
        db.collection("CryptoList").get()
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
                                Asset c = d.toObject(Asset.class);

                                // and we will pass this object class
                                // inside our arraylist which we have
                                // created for recycler view.
                                assetsArrayList.add(c);
                            }
                            // after adding the data to recycler view.
                            // we are calling recycler view notifuDataSetChanged
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
}