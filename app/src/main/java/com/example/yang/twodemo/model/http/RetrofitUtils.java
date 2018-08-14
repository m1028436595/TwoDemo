package com.example.yang.twodemo.model.http;

import com.example.yang.twodemo.config.Urls;
import com.example.yang.twodemo.model.biz.HomeApiService;
import com.example.yang.twodemo.model.callback.NetWorkCallback;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RetrofitUtils implements IHttp {
    private static RetrofitUtils retrofitUtils;
    private final Retrofit.Builder builder;
    private Retrofit retrofit;


    private RetrofitUtils(){
        builder = new Retrofit.Builder();
    }
    public static RetrofitUtils getInstance(){
        if (retrofitUtils==null){
            synchronized (RetrofitUtils.class){
                if (retrofitUtils==null){
                    retrofitUtils=new RetrofitUtils();
                }
            }
        }
        return retrofitUtils;
    }
    @Override
    public <T> void doGet(String url, NetWorkCallback<T> callback) {

        retrofit = builder.baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();


    }


    @Override
    public <T> void doPost(String url, Map<String, String> params, NetWorkCallback<T> callback) {


    }

    public HomeApiService getHomeApiservice(){
        HomeApiService homeApiService = retrofit.create(HomeApiService.class);
        return homeApiService;
    }
}
