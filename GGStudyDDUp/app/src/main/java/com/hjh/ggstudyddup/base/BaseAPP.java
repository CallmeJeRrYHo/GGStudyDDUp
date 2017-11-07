package com.hjh.ggstudyddup.base;

import android.app.Application;

import com.hjh.ggstudyddup.di.component.AppComponent;
import com.hjh.ggstudyddup.di.component.DaggerAppComponent;
import com.hjh.ggstudyddup.di.module.AppModule;
import com.hjh.ggstudyddup.di.module.HttpModule;
import com.hjh.greentest.DaoMaster;
import com.hjh.greentest.DaoSession;

import org.greenrobot.greendao.database.Database;

/**
 * Created by HJH on 2017/6/28.
 */

public class BaseAPP extends Application {
    private static DaoSession mSession;
    private static AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        intiGreenDao();
        setupComponent();
    }
    private void setupComponent() {
        mAppComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .httpModule(new HttpModule())
                .build();
    }
    //获取AppComponent 以便于SubComponent继承
    public AppComponent getAppComponent() {
        if(mAppComponent == null){
            this.setupComponent();
        }
        return mAppComponent;
    }
    private void intiGreenDao() {
        DaoMaster.DevOpenHelper devOpenHelper=new DaoMaster.DevOpenHelper(this,"test_db");
        Database database = devOpenHelper.getWritableDb();
        mSession=new DaoMaster(database).newSession();
    }
    public static DaoSession getSession(){
        return mSession;
    }
}
