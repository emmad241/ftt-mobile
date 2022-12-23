package com.example.investify.Adapters;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.investify.Classes.Asset;
import com.example.investify.R;

import java.util.ArrayList;

public class AssetRVAdapter extends RecyclerView.Adapter<AssetRVAdapter.ViewHolder> {
    // creating variables for our ArrayList and context
    private ArrayList<Asset> assetArrayList;
    private Context context;
    private ItemClickListener mClickListener;

    // creating constructor for our adapter class
    public AssetRVAdapter(ArrayList<Asset> assetArrayList, Context context) {
        this.assetArrayList = assetArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // passing our layout file for displaying our card item
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.asset_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
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

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // creating variables for our text views.
        private final TextView assetCodeTV;
        private final TextView assetNameTV;
        private final TextView assetPriceTV;
        private final Button buyBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views.
            assetCodeTV = itemView.findViewById(R.id.idTVAssetCode);
            assetNameTV = itemView.findViewById(R.id.idTVAssetName);
            assetPriceTV = itemView.findViewById(R.id.idTVAssetPrice);
            buyBtn = itemView.findViewById(R.id.buyBtn);
            buyBtn.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null)
                mClickListener.onItemClick(view, getBindingAdapterPosition());
        }
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }
}
