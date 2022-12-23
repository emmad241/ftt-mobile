package com.example.investify.Adapters;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.investify.Classes.Asset;
import com.example.investify.R;

import java.util.ArrayList;

public class MyAssetsAdapter extends RecyclerView.Adapter<MyAssetsAdapter.ViewHolder> {
    // creating variables for our ArrayList and context
    private ArrayList<Asset> assetArrayList;
    private Context context;

    // creating constructor for our adapter class
    public MyAssetsAdapter(ArrayList<Asset> assetArrayList, Context context) {
        this.assetArrayList = assetArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAssetsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // passing our layout file for displaying our card item
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.bought_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyAssetsAdapter.ViewHolder holder, int position) {
        // setting data to our text views from our modal class.
        Asset asset = assetArrayList.get(position);
        holder.codeTV.setText(asset.getAssetCode());
        holder.nameTV.setText(asset.getAssetName());
        holder.priceTV.setText(asset.getAssetPrice());
        holder.sixmTV.setText(asset.getAssetPriceSixMonths());
        holder.twelvemTV.setText(asset.getAssetPriceTwelveMonths());
    }

    @Override
    public int getItemCount() {
        // returning the size of our array list.
        return assetArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        // creating variables for our text views.
        private final TextView codeTV;
        private final TextView nameTV;
        private final TextView priceTV;
        private final TextView sixmTV;
        private final TextView twelvemTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views.
            codeTV = itemView.findViewById(R.id.codeTV);
            nameTV = itemView.findViewById(R.id.nameTV);
            priceTV = itemView.findViewById(R.id.currentP);
            sixmTV = itemView.findViewById(R.id.six_m);
            twelvemTV = itemView.findViewById(R.id.twelve_m);
        }
    }
}