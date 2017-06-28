package com.hjh.ggstudyddup;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.hjh.ggstudyddup.base.BaseActivity;
import com.hjh.ggstudyddup.greendao.GreenDaoActivity;
import com.hjh.ggstudyddup.popup.PopupActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.tv_popup)
    TextView mTvPopup;
    @BindView(R.id.tv_green_dao)
    TextView mTvGreenDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.tv_popup)
    public void onViewClicked() {
        Intent i = new Intent(this, PopupActivity.class);
        startActivity(i);
    }


    @OnClick(R.id.tv_green_dao)
    public void onMTvGreenDaoClicked() {
        gotoActivity(GreenDaoActivity.class);
    }
}
