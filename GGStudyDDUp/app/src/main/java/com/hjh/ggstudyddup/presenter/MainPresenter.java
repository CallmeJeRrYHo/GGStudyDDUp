package com.hjh.ggstudyddup.presenter;

import com.hjh.ggstudyddup.base.BasePresenter;
import com.hjh.ggstudyddup.contract.MainContract;
import com.hjh.ggstudyddup.model.MainModel;

/**
 * Created by HJH on 2017/7/8.
 */

public class MainPresenter extends BasePresenter<MainContract.MainView> implements MainContract.Presenter {
    private MainModel mModel;

    public MainPresenter(MainModel model) {
        mModel = model;
    }

    @Override
    public void testData() {
        mView.log("success");
    }
}
