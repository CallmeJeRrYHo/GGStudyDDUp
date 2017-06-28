package com.hjh.ggstudyddup.base;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by HJH on 2017/6/28.
 */

public class BaseActivity extends AppCompatActivity {
    public void gotoActivity(Class cls,boolean finish){
        Intent i=new Intent(this,cls);
        this.startActivity(i);
        if (finish)
            finish();
    }

    public void gotoActivity(Class cls){
        gotoActivity(cls,false);
    }
}
