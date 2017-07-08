package com.hjh.ggstudyddup.base;

/**
 * Created by HJH on 2017/7/8.
 */

public class BasePresenter<V extends BaseView> implements Presenter<V> {
    protected V mView;
    @Override
    public void attachView(V view){
        mView=view;
    }
    @Override
    public void detachView(){
        mView=null;
        //有用rx的话
        //unSubscribe();
    }
    @Override
    public void addSubscribe(){

    }
    @Override
    public void unSubscribe(){

    }

    /**
     * 是否与v层连接
     * @return
     */
    public boolean isAttach(){
        return mView!=null;
    }

    /**
     * 获取v层，进行ui的设置
     * @return
     */
    public V getView(){
        if (mView!=null)
            return mView;
        else
            throw new UnsupportedOperationException("mView为空！！");
    }
}
