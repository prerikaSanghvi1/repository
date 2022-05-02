package com.example.emango1;

import com.google.gson.annotations.SerializedName;

class Authorization {
    @SerializedName("tokenKey")
    private String tokenKey = "146ae5839b9dfd49ccafd775995d17c1b4473276";

    public String getTokenKey() {
        return tokenKey;
    }

    public void setTokenKey(String tokenKey) {
        this.tokenKey = tokenKey;
    }
}
