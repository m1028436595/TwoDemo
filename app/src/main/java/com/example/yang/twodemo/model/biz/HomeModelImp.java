package com.example.yang.twodemo.model.biz;

import com.example.yang.twodemo.model.callback.NetWorkCallback;
import com.example.yang.twodemo.model.entity.Bean;
import com.example.yang.twodemo.model.http.HttpFactory;

public class HomeModelImp implements HomeModel {
    @Override
    public void getDataFromNet(NetWorkCallback<Bean> callback) {
        HttpFactory.create().doGet("",callback);
    }
}
