package com.example.investify.Classes;

import java.util.ArrayList;

public class User {

    private String username;
    private String userType;
    private ArrayList<String> stocks;
    private ArrayList<String> crypto;

    public User(){

    }

    public User(String username, String userType, ArrayList<String> stocks, ArrayList<String> crypto){
        this.username = username;
        this.userType = userType;
        this.stocks = stocks;
        this.crypto = crypto;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public ArrayList<String> getStocks() {
        return stocks;
    }

    public void setStocks(ArrayList<String> stocks) {
        this.stocks = stocks;
    }

    public ArrayList<String> getCrypto() {
        return crypto;
    }

    public void setCrypto(ArrayList<String> crypto) {
        this.crypto = crypto;
    }
}
