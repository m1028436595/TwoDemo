package com.example.yang.twodemo.ui.home.presenter;

import com.example.yang.twodemo.model.biz.HomeModelImp;
import com.example.yang.twodemo.model.callback.NetWorkCallback;
import com.example.yang.twodemo.model.entity.Bean;
import com.example.yang.twodemo.ui.home.contract.HomeContract;

public class HomePresenterImp implements HomeContract.Presenter {
    private HomeContract.View view;
    private HomeModelImp modelImp;

    public HomePresenterImp() {
        modelImp=new HomeModelImp();
    }

    @Override
    public void getData() {

        modelImp.getDataFromNet(new NetWorkCallback<Bean>() {
            @Override
            public void onSuccess(Bean bean) {
                view.showData(bean);
            }

            @Override
            public void onError(String message) {

                view.showMessage(message);
            }
        });
    }

    @Override
    public void attach(HomeContract.View view) {

        this.view=view;
    }

    @Override
    public void decath() {

        this.view=null;
    }
}
