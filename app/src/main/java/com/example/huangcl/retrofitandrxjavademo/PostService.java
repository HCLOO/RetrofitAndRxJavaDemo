package com.example.huangcl.retrofitandrxjavademo;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface PostService {
    @FormUrlEncoded
    @POST("top250")
    Observable<ResponseBody> postIP(@FieldMap Map<String,Integer> params);
}

