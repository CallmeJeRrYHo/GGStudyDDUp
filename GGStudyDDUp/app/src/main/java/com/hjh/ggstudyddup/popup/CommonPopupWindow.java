package com.hjh.ggstudyddup.popup;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;

/**
 * Created by HJH on 2017/6/21.
 */

public class CommonPopupWindow extends PopupWindow {

    private Context mContext;

    public CommonPopupWindow(Context context) {
        mContext = context;
    }

    @Override
    public void dismiss() {
        super.dismiss();
        Window window=((Activity)mContext).getWindow();
        WindowManager.LayoutParams layoutParams=window.getAttributes();
        layoutParams.alpha=1f;
        window.setAttributes(layoutParams);
    }

    public static class Builder{
        private Context mContext;
        private int mResId;
        private View mView;
        private int mWidth= ViewGroup.LayoutParams.WRAP_CONTENT;
        private int mHeight= ViewGroup.LayoutParams.WRAP_CONTENT;
        private float mBackground=0;
        private boolean mTouchable=false;
        private boolean isShowAnima=false;
        private int mStyleId;

        public Builder (Context context){
            this.mContext=context;
        }
        public Builder setView(int resId){
            this.mResId=resId;
            this.mView=null;
            return this;
        }
        public Builder setView(View view){
            this.mView=view;
            this.mResId=0;
            return this;
        }
        public Builder setWidthAndHeight(int width,int height){
            this.mWidth=width;
            this.mHeight=height;
            return this;
        }
        public Builder setBackGroundLevel(float lv){
            this.mBackground=lv;
            return this;
        }

        public Builder setOutsideTouchable(boolean touchable){
            this.mTouchable=touchable;
            return this;
        }

        public Builder setAnimationStyle(int styleId){
            this.isShowAnima=true;
            this.mStyleId=styleId;
            return this;
        }
        public CommonPopupWindow create(){
            CommonPopupWindow popupWindow=new CommonPopupWindow(mContext);
            if (mResId==0){
                popupWindow.setContentView(mView);
            }else {
                popupWindow.setContentView(LayoutInflater.from(mContext).inflate(mResId,null));
            }
            popupWindow.setWidth(mWidth);
            popupWindow.setHeight(mHeight);
            Window window=((Activity)mContext).getWindow();
            WindowManager.LayoutParams layoutParams=window.getAttributes();
            layoutParams.alpha=mBackground;
            window.setAttributes(layoutParams);
            popupWindow.setOutsideTouchable(mTouchable);
            popupWindow.setFocusable(mTouchable);
            popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            if (isShowAnima)
                popupWindow.setAnimationStyle(mStyleId);
            return popupWindow;
        }


    }
}
