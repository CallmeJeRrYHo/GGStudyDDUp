package com.hjh.ggstudyddup.base;

/**
 * Created by HJH on 2017/7/8.
 */

public interface Presenter<V extends BaseView> {
    /**
     * @Author jerry_H
     * @Time 2017年7月8日
     * p层和v层建立连接
     * @param view
     */
    void attachView(V view);

    /**
     * 断开连接防止内存泄露
     */
    void detachView();

    /**
     * 如果有使用rx的话添加往CompositeDisposable里面添加Disposiable，方便同意取消
     * 截断上下流
     */
    void addSubscribe();

    /**
     * 取消订阅一般在detachView中调用
     */
    void unSubscribe();

}
