package com.example.yang.twodemo.base;

public interface BasePresenter<V> {
    void attach(V view);
    void decath();
}
