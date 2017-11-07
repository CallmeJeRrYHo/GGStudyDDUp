package com.hjh.ggstudyddup;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.hjh.ggstudyddup.base.BaseActivity;
import com.hjh.ggstudyddup.contract.MainContract;
import com.hjh.ggstudyddup.greendao.GreenDaoActivity;
import com.hjh.ggstudyddup.login.LoginActivity;
import com.hjh.ggstudyddup.popup.PopupActivity;
import com.hjh.ggstudyddup.presenter.MainPresenter;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<MainPresenter, MainContract.MainView> implements MainContract.MainView {

    @BindView(R.id.tv_popup)
    TextView mTvPopup;
    @BindView(R.id.tv_green_dao)
    TextView mTvGreenDao;
    @BindView(R.id.tv_test)
    TextView mTvTest;
    @BindView(R.id.tv_login)
    TextView mTvLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initComponent() {
        getActivityComponent().add(this);
    }


    @Override
    protected void initView() {
        mPresenter.testData();
        mPresenter.sleep();
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }


    @OnClick(R.id.tv_popup)
    public void onViewClicked2() {
        Intent i = new Intent(this, PopupActivity.class);
        startActivity(i);
    }


    @OnClick(R.id.tv_green_dao)
    public void onMTvGreenDaoClicked() {
        gotoActivity(GreenDaoActivity.class);
    }

    @Override
    public void log(String s) {
        Log.d("11111", s);
    }

    @OnClick(R.id.tv_test)
    public void onViewClicked() {
        Log.d("1111","1111");
        mPresenter.testData();
    }

    @OnClick(R.id.tv_login)
    public void onLogin() {
        gotoActivity(LoginActivity.class);
    }
}
