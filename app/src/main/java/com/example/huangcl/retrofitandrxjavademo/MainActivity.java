package com.example.huangcl.retrofitandrxjavademo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView;
    Button getBtn,postBtn,testGBtn,testPBtn;
    Retrofit getRetrofit,postRetrofit,testGRetrofit,testPRetrofit;
    GetService getService;
    PostService postService;
    GetTest getTest;
    PostTest postTest;
    private final String getBaseUrl="https://api.douban.com/v2/movie/";
    private final String postBaseUrl="https://api.douban.com/v2/movie/";
    private final String getTestBaseUrl="http://mrr-dev.legato-concept.com/mrr2/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=(TextView)findViewById(R.id.text_view);
        getBtn=(Button)findViewById(R.id.btn_get);
        postBtn=(Button)findViewById(R.id.btn_post);
        testGBtn=(Button)findViewById(R.id.btn_test_get);
        testPBtn=(Button)findViewById(R.id.btn_test_post);
        getBtn.setOnClickListener(this);
        postBtn.setOnClickListener(this);
        testGBtn.setOnClickListener(this);
        testPBtn.setOnClickListener(this);

        getRetrofit = new Retrofit.Builder()
                .baseUrl(getBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        postRetrofit = new Retrofit.Builder()
                .baseUrl(postBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        testGRetrofit = new Retrofit.Builder()
                .baseUrl(getTestBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        testPRetrofit = new Retrofit.Builder()
                .baseUrl(getTestBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        getService=getRetrofit.create(GetService.class);
        postService=postRetrofit.create(PostService.class);
        getTest=testGRetrofit.create(GetTest.class);
        postTest=testPRetrofit.create(PostTest.class);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btn_get:
                textView.setText("");
                getService.getTopMovie(10,10)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<ResponseBody>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(ResponseBody responseBody) {
                                try {
                                    String response=responseBody.string();
                                    textView.setText(response);
                                    Log.e( "onNext: ", response);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onError(Throwable e) {
                                textView.setText(e.toString());
                                Log.e( "onError: ", e.toString());
                            }

                            @Override
                            public void onComplete() {

                            }
                        });
                break;

            case R.id.btn_post:
                textView.setText("");
                Map<String,Integer> params1=new HashMap<>();
                params1.put("start",10);
                params1.put("count",10);
                postService.postIP(params1)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<ResponseBody>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(ResponseBody responseBody) {
                                try {
                                    String response=responseBody.string();
                                    textView.setText(response);
                                    Log.e( "onNext: ", response);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onError(Throwable e) {
                                textView.setText(e.toString());
                                Log.e( "onError: ", e.toString());
                            }

                            @Override
                            public void onComplete() {

                            }
                        });
                break;

            case R.id.btn_test_get:
                textView.setText("");
                getTest.getMRR()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<Information>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(Information information) {
                                String response=information.getResult().getStatus()+" "+information.getResult().getMessage();
                                textView.setText(response);
                                Log.e( "onNext: ", response);
                            }

                            @Override
                            public void onError(Throwable e) {
                                textView.setText(e.toString());
                                Log.e( "onError: ", e.toString());
                            }

                            @Override
                            public void onComplete() {

                            }
                        });
                break;

            case R.id.btn_test_post:
                textView.setText("");
                HashMap<String,String> params2=new HashMap<>();
                params2.put("model","iPhone 7 Plus");
                params2.put("brand","Apple");
                params2.put("capacity","32");
                params2.put("color","Black");
                params2.put("device_country","0");
                params2.put("country_id","2");
                params2.put("test_case_type","4");
                postTest.postMRR(params2)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<Information>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(Information information) {
                                String response=information.getResult().getStatus()+" "+information.getResult().getMessage();
                                textView.setText(response);
                                Log.e( "onNext: ", response);
                            }

                            @Override
                            public void onError(Throwable e) {
                                textView.setText(e.toString());
                                Log.e( "onError: ", e.toString());
                            }

                            @Override
                            public void onComplete() {

                            }
                        });
                break;
        }
    }
}
