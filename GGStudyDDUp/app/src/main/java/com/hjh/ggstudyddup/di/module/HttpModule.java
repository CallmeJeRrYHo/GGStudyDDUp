package com.hjh.ggstudyddup.di.module;

import com.hjh.ggstudyddup.base.Url;
import com.hjh.ggstudyddup.model.http.api.GankApi;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by HJH
 * Data 2017/11/7.
 */
@Module
public class HttpModule {
    @Singleton
    @Provides
    public OkHttpClient providerOkhttpClient(){
        return new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .connectTimeout(10, TimeUnit.SECONDS)
                .build();
    }

    @Singleton
    @Provides
    public Retrofit providerRetrofit(OkHttpClient okHttpClient){
        return new Retrofit.Builder()
                .baseUrl(Url.BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Singleton
    @Provides
    public GankApi providerGankApi(Retrofit retrofit){
        return retrofit.create(GankApi.class);
    }
}
