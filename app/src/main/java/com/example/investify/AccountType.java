package com.example.investify;

public class AccountType {

    private String user;

    private String userType;

    public AccountType(){

    }

    public AccountType(String user, String userType) {
        this.user = user;
        this.userType = userType;
    }


    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

}
