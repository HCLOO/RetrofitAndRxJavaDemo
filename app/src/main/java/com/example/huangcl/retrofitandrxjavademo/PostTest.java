package com.example.huangcl.retrofitandrxjavademo;

import java.util.HashMap;
import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface PostTest {
    @FormUrlEncoded
    @Headers({"Accept: application/json","Authorization: Basic OTg3NjU0MzI6c0pvWERnNUxRMGh4WmpmV0NidlBucVNDdFBPSTFCVERZNHpSY0U1ZkZNcWR5T3VTS3dzZVZ2a0ZieWhXTlZ4bA=="})
    @POST("retailer_price_table/getModelPrice")
    Observable<Information> postMRR(@FieldMap HashMap<String,String> params);
}
