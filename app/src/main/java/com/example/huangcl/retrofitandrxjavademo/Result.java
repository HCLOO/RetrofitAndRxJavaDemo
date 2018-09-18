package com.example.huangcl.retrofitandrxjavademo;

import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("status")
    private String status;
    @SerializedName("message")
    private String message;

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
