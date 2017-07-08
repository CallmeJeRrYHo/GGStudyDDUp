package com.hjh.ggstudyddup.base;

/**
 * Created by HJH on 2017/7/8.
 */

public interface BaseView {
    void showMessage(String msg);
    void showLoading(String msg);
    void showLoading();
    void hideLoading();
    void showRefresh();
    void hideRefresh();
}
