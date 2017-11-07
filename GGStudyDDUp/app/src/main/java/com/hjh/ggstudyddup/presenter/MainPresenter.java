package com.hjh.ggstudyddup.presenter;

import android.util.Log;

import com.hjh.ggstudyddup.base.BasePresenter;
import com.hjh.ggstudyddup.contract.MainContract;
import com.hjh.ggstudyddup.model.MainModel;
import com.hjh.ggstudyddup.model.bean.GankResult;
import com.hjh.ggstudyddup.model.http.api.RetrofitHelper;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by HJH on 2017/7/8.
 */

public class MainPresenter extends BasePresenter<MainContract.MainView> implements MainContract.Presenter {
    private MainModel mModel;
    private RetrofitHelper mRetrofitHelper;
    @Inject
    public MainPresenter(RetrofitHelper helper) {
        mRetrofitHelper = helper;
    }

    @Override
    public void testData() {
        mRetrofitHelper.getGirlList(10,1)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new Subscriber<GankResult>() {
                    @Override
                    public void onSubscribe(Subscription s) {

                    }

                    @Override
                    public void onNext(GankResult s) {
                        Log.d("http",s.getResults().get(0).getDesc());
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.d("http",t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.d("http","comple");
                    }
                });
    }

    @Override
    public void sleep() {
    }
}
