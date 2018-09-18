package com.example.huangcl.retrofitandrxjavademo;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface GetTest {
    @Headers("Accept: application/json")
    @GET("api/get_all/v1/1/0.1/4/0000-00-00T00:00:00")
    Observable<Information> getMRR();
}
