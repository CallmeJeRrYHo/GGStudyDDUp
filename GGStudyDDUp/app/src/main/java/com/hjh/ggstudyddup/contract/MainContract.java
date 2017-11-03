package com.hjh.ggstudyddup.contract;

import com.hjh.ggstudyddup.base.BaseView;

/**
 * Created by HJH on 2017/7/8.
 */

public interface MainContract {
    interface Model {
    }

    interface MainView extends BaseView{
        void log(String  s);
    }

    interface Presenter {
        void testData();
        void sleep();
    }
}
