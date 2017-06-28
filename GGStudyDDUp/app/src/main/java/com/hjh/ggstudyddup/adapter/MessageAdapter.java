package com.hjh.ggstudyddup.adapter;

import android.support.annotation.Nullable;
import android.util.Log;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hjh.ggstudyddup.R;
import com.hjh.ggstudyddup.bean.Message;

import java.util.List;

/**
 * Created by HJH on 2017/6/29.
 */

public class MessageAdapter extends BaseQuickAdapter<Message,BaseViewHolder>{
    public MessageAdapter( @Nullable List<Message> data) {
        super(R.layout.item_message, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Message item) {
        helper.setText(R.id.tv_title,item.getTitle())
                .setText(R.id.tv_content,item.getContent())
                .setText(R.id.tv_time,item.getCreateTime());
        Log.d("tag",item.getId()+"");
    }
}
