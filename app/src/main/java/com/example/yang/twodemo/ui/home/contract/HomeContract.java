package com.example.yang.twodemo.ui.home.contract;

import com.example.yang.twodemo.base.BasePresenter;
import com.example.yang.twodemo.base.BaseView;
import com.example.yang.twodemo.model.entity.Bean;

public interface HomeContract {
    interface View extends BaseView{
        void showData(Bean bean);
        void showMessage(String message);

    }
    interface Presenter extends BasePresenter<View>{
        void getData();

    }
}
