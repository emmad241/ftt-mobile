package com.example.investify;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class AssetRVAdapter extends RecyclerView.Adapter<AssetRVAdapter.ViewHolder> {
    // creating variables for our ArrayList and context
    private ArrayList<Asset> assetArrayList;
    private Context context;

    // creating constructor for our adapter class
    public AssetRVAdapter(ArrayList<Asset> assetArrayList, Context context) {
        this.assetArrayList = assetArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public AssetRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // passing our layout file for displaying our card item
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.asset_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AssetRVAdapter.ViewHolder holder, int position) {
        // setting data to our text views from our modal class.
        Asset asset = assetArrayList.get(position);
        holder.assetCodeTV.setText(asset.getAssetCode());
        holder.assetNameTV.setText(asset.getAssetName());
        holder.assetPriceTV.setText(asset.getAssetPrice());
    }

    @Override
    public int getItemCount() {
        // returning the size of our array list.
        return assetArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        // creating variables for our text views.
        private final TextView assetCodeTV;
        private final TextView assetNameTV;
        private final TextView assetPriceTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views.
            assetCodeTV = itemView.findViewById(R.id.idTVAssetCode);
            assetNameTV = itemView.findViewById(R.id.idTVAssetName);
            assetPriceTV = itemView.findViewById(R.id.idTVAssetPrice);
        }
    }
}
