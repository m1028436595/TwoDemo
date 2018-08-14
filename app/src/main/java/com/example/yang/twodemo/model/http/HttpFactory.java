package com.example.yang.twodemo.model.http;

public class HttpFactory {

    public static IHttp create(){
        return RetrofitUtils.getInstance();
    }
}
