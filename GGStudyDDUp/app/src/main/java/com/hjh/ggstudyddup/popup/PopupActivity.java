package com.hjh.ggstudyddup.popup;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.hjh.ggstudyddup.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PopupActivity extends AppCompatActivity {

    @BindView(R.id.tv_drop_down)
    TextView mTvDropDown;
    @BindView(R.id.tv_drop_right)
    TextView mTvDropRight;
    @BindView(R.id.tv_drop_up)
    TextView mTvDropUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_drop_down, R.id.tv_drop_right, R.id.tv_drop_up})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_drop_down:
                CommonPopupWindow down=new CommonPopupWindow.Builder(this)
                        .setView(R.layout.popup_down)
                        .setOutsideTouchable(true)
                        .setAnimationStyle(R.style.popup_drop_down)
                        .setBackGroundLevel(0.5f)
                        .create();
                down.showAsDropDown(mTvDropDown);
                break;
            case R.id.tv_drop_right:
                CommonPopupWindow right=new CommonPopupWindow.Builder(this)
                        .setView(R.layout.popup_right)
                        .setOutsideTouchable(true)
                        .setAnimationStyle(R.style.popup_drop_right)
                        .setBackGroundLevel(0.5f)
                        .create();
                right.showAsDropDown(mTvDropRight,mTvDropRight.getWidth(),-mTvDropRight.getHeight());
                break;
            case R.id.tv_drop_up:
                break;
        }
    }
}
