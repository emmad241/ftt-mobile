package com.example.investify;

public class Asset {

    // variables for storing our data.
    private String assetCode, assetName, assetPrice;

    public Asset() {
        // empty constructor
        // required for Firebase.
    }

    // Constructor for all variables.
    public Asset(String assetCode, String assetName, String assetPrice) {
        this.assetCode = assetCode;
        this.assetName = assetName;
        this.assetPrice = assetPrice;
    }

    // getter methods for all variables.
    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }

    public String getAssetName() {
        return assetName;
    }

    // setter method for all variables.
    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getAssetPrice() {
        return assetPrice;
    }

    public void setAssetPrice(String assetPrice) {
        this.assetPrice = assetPrice;
    }
}

