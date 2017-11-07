package com.hjh.ggstudyddup.di.component;

import android.app.Activity;

import com.hjh.ggstudyddup.MainActivity;
import com.hjh.ggstudyddup.di.module.ActivityModule;
import com.hjh.ggstudyddup.di.scope.ActivityScope;
import com.hjh.ggstudyddup.login.LoginActivity;

import dagger.Component;

/**
 * Created by HJH
 * Data 2017/11/7.
 */
@ActivityScope
@Component(dependencies = AppComponent.class,modules = ActivityModule.class)
public interface ActivityComponent {
    Activity getActivty();
    void add(MainActivity mainActivity);
    void inject(LoginActivity loginActivity);
}
