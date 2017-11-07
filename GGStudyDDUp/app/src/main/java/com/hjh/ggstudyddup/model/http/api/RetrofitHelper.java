package com.hjh.ggstudyddup.model.http.api;

import com.hjh.ggstudyddup.model.bean.GankResult;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * Created by HJH
 * Data 2017/11/7.
 */

public class RetrofitHelper implements HttpHelper{
    private GankApi mGankApi;

    @Inject
    public RetrofitHelper(GankApi gankApi) {
        mGankApi = gankApi;
    }

    @Override
    public Flowable<GankResult> getGirlList(int num, int pageSize){
        return mGankApi.getGirlList(num,pageSize);
    }
}
