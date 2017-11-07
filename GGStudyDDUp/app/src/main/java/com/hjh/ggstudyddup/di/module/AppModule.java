package com.hjh.ggstudyddup.di.module;

import android.content.Context;

import com.hjh.ggstudyddup.base.BaseAPP;
import com.hjh.ggstudyddup.model.MainModel;
import com.hjh.ggstudyddup.model.http.api.HttpHelper;
import com.hjh.ggstudyddup.model.http.api.RetrofitHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by HJH
 * Data 2017/11/7.
 */
@Module
public class AppModule {
    private Context context;

    public AppModule(BaseAPP application) {
        this.context = application;
    }

    @Singleton
    @Provides
    public Context ProviderApplicationContext(){
        return context;
    }

    @Singleton
    @Provides
    public MainModel providerMainModel(MainModel mainModel){
        return mainModel;
    }

    @Singleton
    @Provides
    public HttpHelper providerRetrofitHelper(RetrofitHelper retrofitHelper){
        return retrofitHelper;
    }
}
