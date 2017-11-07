package com.hjh.ggstudyddup.model.http.api;

import com.hjh.ggstudyddup.model.bean.GankResult;

import io.reactivex.Flowable;

/**
 * Created by HJH
 * Data 2017/11/7.
 */

public interface HttpHelper {
    Flowable<GankResult> getGirlList(int num, int pageSize);
}
