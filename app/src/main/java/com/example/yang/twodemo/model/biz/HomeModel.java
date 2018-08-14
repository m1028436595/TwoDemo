package com.example.yang.twodemo.model.biz;

import com.example.yang.twodemo.model.callback.NetWorkCallback;
import com.example.yang.twodemo.model.entity.Bean;

public interface HomeModel {
    void getDataFromNet(NetWorkCallback<Bean> callback);

}
