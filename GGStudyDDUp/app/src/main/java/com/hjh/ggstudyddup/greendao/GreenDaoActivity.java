package com.hjh.ggstudyddup.greendao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hjh.ggstudyddup.R;
import com.hjh.ggstudyddup.adapter.MessageAdapter;
import com.hjh.ggstudyddup.base.BaseAPP;
import com.hjh.ggstudyddup.bean.Message;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GreenDaoActivity extends AppCompatActivity {

    @BindView(R.id.btn_add)
    Button mBtnAdd;
    @BindView(R.id.btn_delete)
    Button mBtnDelete;
    @BindView(R.id.btn_check)
    Button mBtnCheck;
    @BindView(R.id.btn_update)
    Button mBtnUpdate;
    @BindView(R.id.et_title)
    EditText mEtTitle;
    @BindView(R.id.et_content)
    EditText mEtContent;
    @BindView(R.id.rv)
    RecyclerView mRv;
    private List<Message> mData = new ArrayList<>();
    private MessageAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_green_dao);
        ButterKnife.bind(this);
        mAdapter = new MessageAdapter(mData);
        mRv.setLayoutManager(new LinearLayoutManager(this));
        mRv.setAdapter(mAdapter);
    }

    @OnClick(R.id.btn_add)
    public void onMBtnAddClicked() {
        Message message = new Message();
        message.setTitle(mEtTitle.getText().toString());
        message.setContent(mEtContent.getText().toString());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        message.setCreateTime(simpleDateFormat.format(new Date()));
        Log.d("tag",message.getId()+"");
        try {
            ((BaseAPP) getApplication()).getSession().getMessageDao().insert(message);

        } catch (Exception e) {
            Log.d("tag",e.getMessage());
            Toast.makeText(this, "insert Fail!!", Toast.LENGTH_LONG).show();
        }
        Toast.makeText(this, "insert Success!!", Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.btn_delete)
    public void onMBtnDeleteClicked() {
    }

    @OnClick(R.id.btn_check)
    public void onMBtnCheckClicked() {
        List<Message> list = ((BaseAPP) getApplication()).getSession().getMessageDao().loadAll();
        mAdapter.setNewData(list);
    }

    @OnClick(R.id.btn_update)
    public void onMBtnUpdateClicked() {
    }
}
