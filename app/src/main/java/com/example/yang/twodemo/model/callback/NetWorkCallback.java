package com.example.yang.twodemo.model.callback;

public interface NetWorkCallback<T> {
    void onSuccess(T t);
    void onError(String message);
}
