package com.example.yang.twodemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yang.twodemo.model.entity.Bean;
import com.example.yang.twodemo.ui.home.contract.HomeContract;
import com.example.yang.twodemo.ui.home.presenter.HomePresenterImp;

public class MainActivity extends AppCompatActivity implements HomeContract.View{

    private HomePresenterImp homePresenterImp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homePresenterImp = new HomePresenterImp();
        homePresenterImp.attach(this);
        homePresenterImp.getData();
    }

    @Override
    public void showData(Bean bean) {


    }

    @Override
    public void showMessage(String message) {


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        homePresenterImp.decath();
    }
}
