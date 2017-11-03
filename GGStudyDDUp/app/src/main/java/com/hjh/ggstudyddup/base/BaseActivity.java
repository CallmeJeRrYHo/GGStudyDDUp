package com.hjh.ggstudyddup.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.hjh.ggstudyddup.utils.ActivityTool;

import butterknife.ButterKnife;

/**
 * base
 * Created by HJH on 2017/6/28.
 */

public abstract class BaseActivity<P extends BasePresenter,V extends BaseView> extends AppCompatActivity implements BaseView{
    protected P mPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        ButterKnife.bind(this);
        mPresenter=getPresenter();
        if (mPresenter!=null)
            mPresenter.attachView((V)this);
        initView();
        ActivityTool.addActivity(this);
    }

    /**
     * 返回view id
     * @return
     */
    protected abstract int getContentViewId();

    /**
     * 返回p层
     * @return
     */
    protected abstract P getPresenter();

    protected abstract void initView();

    /**
     * 跳转到指定act
     * @param cls
     * @param finish
     */
    public void gotoActivity(Class cls, boolean finish){
        Intent i=new Intent(this,cls);
        this.startActivity(i);
        if (finish)
            finish();
    }


    public void gotoActivity(Class cls){
        gotoActivity(cls,false);
    }


    @Override
    protected void onDestroy() {
        if (mPresenter!=null)
            mPresenter.detachView();
        super.onDestroy();

    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void showLoading(String msg) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showRefresh() {

    }

    @Override
    public void hideRefresh() {

    }
}
