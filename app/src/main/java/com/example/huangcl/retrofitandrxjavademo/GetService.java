package com.example.huangcl.retrofitandrxjavademo;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetService {
    @GET("top250")
    Observable<ResponseBody> getTopMovie(@Query("start")int start, @Query("count")int count);
}
