package com.hjh.ggstudyddup.base;

import android.app.Application;

import com.hjh.greentest.DaoMaster;
import com.hjh.greentest.DaoSession;

import org.greenrobot.greendao.database.Database;

/**
 * Created by HJH on 2017/6/28.
 */

public class BaseAPP extends Application {
    private static DaoSession mSession;

    @Override
    public void onCreate() {
        super.onCreate();
        intiGreenDao();
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
