package com.hjh.ggstudyddup.di.component;

import com.hjh.ggstudyddup.di.module.AppModule;
import com.hjh.ggstudyddup.di.module.HttpModule;
import com.hjh.ggstudyddup.model.http.api.RetrofitHelper;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by HJH
 * Data 2017/11/7.
 */

@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {
    RetrofitHelper retrofitHelper();  //提供http的帮助类

}
