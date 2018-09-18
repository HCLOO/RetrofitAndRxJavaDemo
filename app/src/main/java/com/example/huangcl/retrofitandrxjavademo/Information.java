package com.example.huangcl.retrofitandrxjavademo;

import com.google.gson.annotations.SerializedName;

public class Information {

    @SerializedName("result")
    private Result result;

    public void setResult(Result result) {
        this.result = result;
    }

    public Result getResult() {
        return result;
    }
}
