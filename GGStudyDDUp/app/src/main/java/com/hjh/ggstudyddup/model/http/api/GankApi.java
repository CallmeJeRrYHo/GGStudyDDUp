package com.hjh.ggstudyddup.model.http.api;

import com.hjh.ggstudyddup.model.bean.GankResult;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by HJH
 * Data 2017/11/7.
 */

public interface GankApi {
    @GET("data/福利/{num}/{pageSize}")
    Flowable<GankResult> getGirlList(@Path("num") int num, @Path("pageSize") int pageSize);
}
