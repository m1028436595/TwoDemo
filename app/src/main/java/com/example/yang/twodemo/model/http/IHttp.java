package com.example.yang.twodemo.model.http;

import com.example.yang.twodemo.model.callback.NetWorkCallback;

import java.util.Map;

public interface IHttp {

    <T> void doGet(String url,NetWorkCallback<T> callback);
    //<T> void doGet(String url, Map<String,String> params,NetWorkCallback<T> callback);
    <T> void doPost(String url,Map<String,String> params,NetWorkCallback<T> callback);
}
