package com.hjh.ggstudyddup.login.presenter;

import com.hjh.ggstudyddup.base.BasePresenter;
import com.hjh.ggstudyddup.login.contract.LoginContract;

import javax.inject.Inject;

/**
 * Created by HJH
 * Data 2017/11/3.
 */

public class LoginPresenter extends BasePresenter<LoginContract.LoginView> implements LoginContract.Presenter {
    @Inject
    public LoginPresenter(){

    }
}
